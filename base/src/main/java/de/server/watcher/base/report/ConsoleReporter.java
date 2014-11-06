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
import de.server.watcher.base.domain.Cpu;
import de.server.watcher.base.domain.DetectorResult;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;
import de.server.watcher.utils.AssertionUtils;

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
    DetectorResult result = DetectorResultMetaHolder.instance().get();

    if (AssertionUtils.isNotNull(result.getCpu())) {
      Cpu cpu = result.getCpu();
      sb.append("//======= CPU INFORMATION =======//");
      sb.append("CPU Name: ").append(cpu.getBrand());
      sb.append("Architecture: ").append(cpu.getArchitecture()).append((cpu.isBit64()) ? "x64" : "x86");
      sb.append("Running @ ").append(cpu.getCores()).append("x").append(cpu.getCpuFrequency());
      sb.append("Max Available @ ").append(cpu.getCores()).append("x").append(cpu.getMaxCpuFrequency());
      sb.append("Max virtual Cores: ").append(cpu.getVirtualCores());
    }
    if (AssertionUtils.isNotNull(result.getMemory())) {

    }
    LOGGER.debug("prepare @ ConsoleReporter");

  }

  @Override
  public void sendReport() {
    LOGGER.debug("send @ ConsoleReporter");
  }
}
