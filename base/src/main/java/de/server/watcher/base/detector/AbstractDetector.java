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
import java.util.StringTokenizer;

import com.google.common.collect.Maps;

import org.apache.commons.exec.DefaultExecutor;
import org.apache.log4j.Logger;

import de.server.watcher.base.annotation.Detector;
import de.server.watcher.utils.CommandLineUtils;

/**
 * Created by svenklemmer on 04.11.14.
 * <p/>
 * "Master Detector" implementing some standard methods
 * for detecting nice information about the client
 */
@Detector
public abstract class AbstractDetector {
  private static final Logger LOGGER = Logger.getLogger(AbstractDetector.class);

  private DefaultExecutor executor;

  private static final String MAC_COMMAND = "sysctl machdep hw";
  private static final String[] LINUX_COMMAND = { "lscpu", "cat /proc/cpuinfo" };

  public abstract void detect() throws Exception;

  public Map<String, String> watchMac() throws Exception {
    String commandOutput = CommandLineUtils.execToString(MAC_COMMAND);
    return createMap(commandOutput);
  }

  public Map<String, String> watchWindows() throws Exception {
    return Maps.newHashMap();
  }

  public Map<String, String> watchLinux() throws Exception {
    String commandOutput = CommandLineUtils.execToString(LINUX_COMMAND[0]);
    commandOutput = commandOutput + "\n " + CommandLineUtils.execToString(LINUX_COMMAND[1]);
    return createMap(commandOutput);
  }

  private Map<String, String> createMap(String input) {
    return createMap(input, ":");
  }

  private Map<String, String> createMap(String input, String tokendelimiter) {
    Map<String, String> sysPropeties = Maps.newHashMap();

    StringTokenizer st = new StringTokenizer(input, "\n");
    while (st.hasMoreTokens()) {
      String[] array = st.nextToken().split(tokendelimiter);
      sysPropeties.put(array[0], array[1].trim());
    }
    return sysPropeties;
  }
}
