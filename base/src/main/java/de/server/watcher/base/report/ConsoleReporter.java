/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.report;

import org.apache.log4j.Logger;

import de.server.watcher.base.annotation.Reporter;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * ConsoleReporter just takes all information and
 * puts them in a nice clean format and prints them via LOGGER.info
 */
@Reporter
public class ConsoleReporter extends AbstractReporter {
  private static final Logger LOGGER = Logger.getLogger(ConsoleReporter.class);

  private StringBuilder sb = new StringBuilder();

  @Override
  public void prepare() {
    LOGGER.debug("prepare @ ConsoleReporter");
  }

  @Override
  public void sendReport() {
    LOGGER.debug("send @ ConsoleReporter");
  }
}
