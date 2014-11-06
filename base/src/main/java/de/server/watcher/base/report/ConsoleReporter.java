/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.report;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import de.server.watcher.base.annotation.Reporter;
import de.server.watcher.base.domain.Cpu;
import de.server.watcher.base.domain.DetectorResult;
import de.server.watcher.base.domain.Hardware;
import de.server.watcher.base.domain.Jvm;
import de.server.watcher.base.domain.Memory;
import de.server.watcher.base.domain.Network;
import de.server.watcher.base.domain.Os;
import de.server.watcher.base.domain.Storage;
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

    sb.append("SERVER-WATCHER: Detection @ ");
    sb.append(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date())).append("\n");

    if (AssertionUtils.isNotNull(result.getCpu())) {
      Cpu cpu = result.getCpu();
      sb.append("//======= CPU INFORMATION =======//").append("\n");
      sb.append("CPU Name: ").append(cpu.getBrand()).append("\n");
      sb.append("Architecture: ").append(cpu.getArchitecture()).append("\n");
      sb.append("64 Bit Support?: ").append((cpu.isBit64()) ? "yes" : "no").append("\n");
      sb.append("Running ").append(cpu.getCores()).append("x @").append(cpu.getCpuFrequency()).append("\n");
      sb.append("Max Available ").append(cpu.getCores()).append("x @").append(cpu.getMaxCpuFrequency()).append("\n");
      sb.append("Max virtual Cores: ").append(cpu.getVirtualCores()).append("\n");
    }
    if (AssertionUtils.isNotNull(result.getMemory())) {
      Memory mem = result.getMemory();
      sb.append("//======= Memory INFORMATION =======//").append("\n");
      sb.append("Free Memory: ").append(mem.getFreeMemSize()).append("\n");
      sb.append("Used Memory: ").append(mem.getUsedMemSize()).append("\n");
      sb.append("Total Memory: ").append(mem.getMaxMemSize()).append("\n");
    }
    if (AssertionUtils.isNotNull(result.getStorage())) {
      Storage disk = result.getStorage();
      sb.append("//======= Storage INFORMATION =======//").append("\n");
      /*sb.append("Free Memory Name: ").append(mem.getFreeMemSize());
      sb.append("Used Memory: ").append(mem.getUsedMemSize());
      sb.append("Total Memory: ").append(mem.getMaxMemSize());*/
    }
    if (AssertionUtils.isNotNull(result.getNetwork())) {
      Network net = result.getNetwork();
      sb.append("//======= Network INFORMATION =======//").append("\n");
      sb.append("Domain: ").append(net.getDomainName()).append("\n");
      sb.append("Hostname: ").append(net.getHostname()).append("\n");
      sb.append("Public IP: ").append(net.getIpAdress()).append("\n");
      sb.append("Mac Adresse ").append(net.getMacAdress()).append("\n");
      sb.append("Subnetmask ").append(net.getSubnet()).append("\n");
    }
    if (AssertionUtils.isNotNull(result.getHardware())) {
      Hardware hard = result.getHardware();
      sb.append("//======= Hardware INFORMATION =======//").append("\n");
    }
    if (AssertionUtils.isNotNull(result.getOs())) {
      Os os = result.getOs();
      sb.append("//======= Operating System INFORMATION =======//").append("\n");
      sb.append("Name: ").append(os.getName()).append("\n");
      sb.append("Version: ").append(os.getVersion()).append("\n");
      sb.append("Architecture: ").append(os.getArchitecture()).append("\n");
    }
    if (AssertionUtils.isNotNull(result.getJvm())) {
      Jvm jvm = result.getJvm();
      sb.append("//======= Java Virtual Machine INFORMATION =======//").append("\n");
      sb.append("Java VM Name: ").append(jvm.getJavaVMName()).append("\n");
      sb.append("Java VM Version: ").append(jvm.getJavaVMVersion()).append("\n");
      sb.append("Java VM Spec: ").append(jvm.getJavaVMSpec()).append("\n");

      sb.append("Java Runtime Name: ").append(jvm.getJavaRuntimeName()).append("\n");
      sb.append("Java Runtime Version: ").append(jvm.getJavaRuntimeVersion()).append("\n");

      sb.append("Java Version: ").append(jvm.getJavaVersion()).append("\n");
      sb.append("Java Class Version: ").append(jvm.getJavaClassVersion()).append("\n");

      sb.append("Java Home Path: ").append(jvm.getJavaHome()).append("\n");
      sb.append("Java Tmp Dir: ").append(jvm.getJavaTmpDir()).append("\n");
    }
  }

  @Override
  public void sendReport() {
    if (sb.toString().length() > 0) {
      LOGGER.info("\n" + sb.toString());
    } else {
      LOGGER.error("Has no informations to print, please check your system");
    }
  }
}
