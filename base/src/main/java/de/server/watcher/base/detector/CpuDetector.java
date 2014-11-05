/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.detector;

import java.util.Map;

import org.apache.log4j.Logger;

import de.server.watcher.base.annotation.Detector;
import de.server.watcher.base.domain.Cpu;
import de.server.watcher.base.domain.Result;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;

/**
 * Created by svenklemmer on 04.11.14.
 */
@Detector
public class CpuDetector extends AbstractDetector {
  private static final Logger LOGGER = Logger.getLogger(CpuDetector.class);

  @Override
  public void detect() throws Exception {
    Result r = DetectorResultMetaHolder.instance().get();
    Cpu cpu = new Cpu();

    Map<String, String> propertiesMap;

    String osName = System.getProperty("os.name");
    if (osName.contains("Mac")) {
      propertiesMap = super.watchMac();

      cpu
          .setBrand(propertiesMap.get("machdep.cpu.brand_string"))
          .setCores(Integer.valueOf(propertiesMap.get("machdep.cpu.core_count")))
          .setVirtualCores(Integer.valueOf(propertiesMap.get("hw.logicalcpu_max")))
          .setCpuFrequency(convertFrequency(propertiesMap.get("hw.cpufrequency")))
          .setMaxCpuFrequency(convertFrequency(propertiesMap.get("hw.cpufrequency_max")))
          .setBit64(propertiesMap.get("hw.cpu64bit_capable").contains("1"))
          .setArchitecture((propertiesMap.get("hw.cpu64bit_capable").contains("1")) ? "x86_64" : "x86");
    } else if (osName.contains("Windows")) {
      propertiesMap = super.watchWindows();
      //TODO: detect properties on windows
    } else {
      propertiesMap = super.watchLinux();
      LOGGER.error(propertiesMap);
      cpu
          .setBrand(propertiesMap.get("model name"))
          .setCores(Integer.valueOf(propertiesMap.get("Core(s) per socket")))
          .setVirtualCores(cpu.getCores())
          .setCpuFrequency(convertMhzToGHz(propertiesMap.get("CPU MHz")))
          .setMaxCpuFrequency(cpu.getCpuFrequency())
          .setBit64((propertiesMap.get("CPU op-mode(s)").contains("64")))
          .setArchitecture(propertiesMap.get("Architecture"));
    }
    LOGGER.debug("Detected Cpu Information: " + cpu);
    r.setCpu(cpu);
  }

  private String convertFrequency(String value) {
    String[] si = { "Hz", "kHz", "MHz", "GHz", "PHz", "THz" };
    double f = Double.parseDouble(value);
    int step = 0;
    while (f > 1000) {
      f /= 1000;
      step++;
    }
    return f + " " + si[step];
  }

  private String convertMhzToGHz(String value) {
    double f = Double.parseDouble(value);
    f /= 1000;
    return f + " Ghz";
  }
}
