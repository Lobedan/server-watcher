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

  private static final String[] MAC_COMMAND = { "sysctl machdep hw", "vm_stat", "ipconfig getpacket en0" };
  private static final String[] LINUX_COMMAND = { "lscpu", "cat /proc/cpuinfo" };

  public abstract void detect() throws Exception;

  public Map<String, String> watchMac() throws Exception {
    String commandOutput = CommandLineUtils.execToString(MAC_COMMAND[0]);
    return createMap(commandOutput);
  }

  public Map<String, String> watchMacMemory() throws Exception {
    String commandOutput = CommandLineUtils.execToString(MAC_COMMAND[1]);
    return createMap(commandOutput);
  }

  public Map<String, String> watchMacNetwork() throws Exception {
    String sb = CommandLineUtils.execToString(MAC_COMMAND[2]);
    String[] split = sb.split("options:");
    Map<String, String> first = createMap(split[0], "=");
    split[1] = split[1].replace("Options count is", "Options count is:");
    first.putAll(createMap(split[1]));

    LOGGER.debug(first);
    return first;
  }

  public Map<String, String> watchWindows() throws Exception {
    return Maps.newHashMap();
  }

  public Map<String, String> watchLinux() throws Exception {
    String commandOutput = CommandLineUtils.execToString(LINUX_COMMAND[0]);
    commandOutput = commandOutput + "\n " + CommandLineUtils.execToString(LINUX_COMMAND[1]);
    return createMap(commandOutput.trim());
  }

  private Map<String, String> createMap(String input) {
    return createMap(input, ":");
  }

  private Map<String, String> createMap(String input, String tokendelimiter) {
    Map<String, String> sysPropeties = Maps.newHashMap();

    StringTokenizer st = new StringTokenizer(input, "\n");
    while (st.hasMoreTokens()) {
      String[] array = st.nextToken().split(tokendelimiter);
      sysPropeties.put(array[0].trim(), array[1].trim());
    }
    return sysPropeties;
  }

  public String convertFrequency(String value) {
    String[] si = { "Hz", "kHz", "MHz", "GHz", "PHz", "THz" };
    double f = Double.parseDouble(value);
    int step = 0;
    while (f > 1000) {
      f /= 1000;
      step++;
    }
    return f + " " + si[step];
  }

  public String convertMhzToGHz(String value) {
    double f = Double.parseDouble(value);
    f /= 1000;
    return f + " Ghz";
  }

  public String convertMbToGb(String value) {
    double f = Double.parseDouble(value);
    f /= 1024;
    return f + " GB";
  }
}
