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
import org.springframework.stereotype.Service;

/**
 * Created by svenklemmer on 04.11.14.
 */
@Service(value = "console")
public class ConsoleReporter extends AbstractReporter {
  private static final Logger LOGGER = Logger.getLogger(ConsoleReporter.class);

  @Override
  public void prepare() {

  }

  @Override
  public void send() {

  }
}
