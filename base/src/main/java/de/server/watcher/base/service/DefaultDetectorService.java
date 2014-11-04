/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * Finds detectors annotated with {@link de.server.watcher.base.annotation.Detector}
 * and runs there #void detect() method
 * this method will insert data to {@link de.server.watcher.base.domain.DetectorResultMetaHolder}
 *
 * after the last detector finishes it will return data back to {@link de.server.watcher.base.tasks.CollectorService}
 * which will proceed
 *
 * this can lead to further detector implementation in case there are more informations its worth detecting :)
 */
@Service(value = "defaultDetector")
public class DefaultDetectorService implements DetectorService{
  private static final Logger LOGGER = Logger.getLogger(DefaultDetectorService.class);
}
