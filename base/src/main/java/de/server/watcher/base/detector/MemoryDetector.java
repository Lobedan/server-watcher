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

import com.google.common.collect.Maps;

import org.apache.log4j.Logger;

import de.server.watcher.base.annotation.Detector;
import de.server.watcher.base.domain.Memory;
import de.server.watcher.base.domain.DetectorResult;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;

/**
 * Created by svenklemmer on 04.11.14.
 */
@Detector
public class MemoryDetector extends AbstractDetector {
  private static final Logger LOGGER = Logger.getLogger(MemoryDetector.class);

  @Override
  public void detect() throws Exception {
    DetectorResult r = DetectorResultMetaHolder.instance().get();
    Memory mem = new Memory();

    Map<String, String> propertiesMap;

    String osName = System.getProperty("os.name");
    if (osName.contains("Mac")) {
      propertiesMap = Maps.newHashMap();
      for (Map.Entry<String, String> entry : super.watchMacMemory().entrySet()) {
        propertiesMap.put(entry.getKey(), entry.getValue().replace(".", "").trim());
      }
      propertiesMap.putAll(super.watchMac());
      mem
          .setFreeMemSize(propertiesMap.get("Pages free"))
          .setUsedMemSize(propertiesMap.get("Pages active"))
          .setMaxMemSize(propertiesMap.get("hw.memsize"));

    } else if (osName.contains("Windows")) {
      propertiesMap = super.watchWindows();
      //TODO: detect properties on windows
    } else {
      propertiesMap = super.watchLinux();
      /*on linux it's almost the same as on mac
      * or use cat /proc/meminfo */
    }
    LOGGER.debug("Detected Memory Information: " + mem);
    r.setMemory(mem);
  }
}
