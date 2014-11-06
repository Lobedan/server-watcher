/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.server.watcher.base.detector.AbstractDetector;

/**
 * Created by svenklemmer on 04.11.14.
 * <p/>
 * Finds detectors annotated with {@link de.server.watcher.base.annotation.Detector}
 * and runs there #void detect() method
 * this method will insert data to {@link de.server.watcher.base.metaholder.DetectorResultMetaHolder}
 * <p/>
 * after the last detector finishes detector will stop
 * <p/>
 * this can lead to more detector implementations in case there are more informations its worth detecting :)
 */
@Service(value = "threadedDetectorService")
public class ThreadedDetectorService implements DetectorService {
  private static final Logger LOGGER = Logger.getLogger(ThreadedDetectorService.class);

  private List<AbstractDetector> detectors;
  private boolean stop = false;

  public void execute() throws Exception {
    final List<Thread> threads = new ArrayList<Thread>();
    for (final AbstractDetector a : detectors) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          threads.add(Thread.currentThread());
          try {
            LOGGER.info("Starting " + a.getClass().getSimpleName());
            a.detect();
          } catch (Exception e) {
            LOGGER.error(e);
          }
        }
      }).start();

      while (!stop) {
        boolean someoneIsWorking = false;
        for (Thread t : threads) {
          if (t.isAlive()) {
            someoneIsWorking = true;
            break;
          }
        }
        if (someoneIsWorking) {
          LOGGER.info("Still running threads left");
          stop = true;
        } else {
          LOGGER.info("no more threads working");
        }
      }
    }
  }

  @Autowired
  public void setDetectors(List<AbstractDetector> aDetectors) {
    detectors = aDetectors;
  }

  public List<AbstractDetector> getDetectors() {
    return detectors;
  }
}
