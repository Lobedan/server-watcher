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

import de.server.watcher.base.detector.AbstractDetector;

/**
 * Created by svenklemmer on 04.11.14.
 */
public interface DetectorService {
  public void execute() throws Exception;

  public void setDetectors(List<AbstractDetector> aDetectors);
  public List<AbstractDetector> getDetectors();
}
