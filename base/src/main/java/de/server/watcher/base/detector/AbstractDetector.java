/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.detector;

import de.server.watcher.base.annotation.Detector;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * "Master Detector" implementing some standard methods
 * for detecting nice information about the client
 */
@Detector
public abstract class AbstractDetector {
  public abstract void detect();

}
