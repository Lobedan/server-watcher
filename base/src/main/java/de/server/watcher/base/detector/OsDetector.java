/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.detector;

import org.apache.log4j.Logger;

import de.server.watcher.base.annotation.Detector;
import de.server.watcher.base.domain.Os;
import de.server.watcher.base.domain.DetectorResult;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;

/**
 * Created by svenklemmer on 04.11.14.
 */
@Detector
public class OsDetector extends AbstractDetector {
  private static final Logger LOGGER = Logger.getLogger(OsDetector.class);

  @Override
  public void detect() {
    DetectorResult r = DetectorResultMetaHolder.instance().get();
    Os os = new Os();
      os
          .setName(System.getProperty("os.name"))
          .setVersion(System.getProperty("os.version"))
          .setArchitecture(System.getProperty("os.arch"));
    r.setOs(os);
    LOGGER.info("Detected OS Information: " + os);
  }
}
