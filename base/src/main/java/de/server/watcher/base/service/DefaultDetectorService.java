/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.service;

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
 * after the last detector finishes it will return data back to {@link de.server.watcher.base.tasks.CollectorTask}
 * which will proceed
 * <p/>
 * this can lead to further detector implementation in case there are more informations its worth detecting :)
 */
@Service(value = "defaultDetector")
public class DefaultDetectorService implements DetectorService {
  private static final Logger LOGGER = Logger.getLogger(DefaultDetectorService.class);

  private List<AbstractDetector> detectors;


  public void execute() throws Exception {
    for (final AbstractDetector a : detectors) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            LOGGER.info("Running in thread " + Thread.currentThread());
            a.detect();
          } catch(Exception e) {
            LOGGER.error(e);
          }
        }
      }).start();
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
