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

    if (AssertionUtils.isNotNull(result.getCpu())) {
      Cpu cpu = result.getCpu();
      sb.append("//======= CPU INFORMATION =======//").append(System.getProperty("\n"));
      sb.append("CPU Name: ").append(cpu.getBrand()).append(System.getProperty("\n"));
      sb.append("Architecture: ").append(cpu.getArchitecture()).append((cpu.isBit64()) ? "x64" : "x86").append(System.getProperty("\n"));
      sb.append("Running @ ").append(cpu.getCores()).append("x").append(cpu.getCpuFrequency()).append(System.getProperty(
          "\n"));
      sb.append("Max Available @ ").append(cpu.getCores()).append("x").append(cpu.getMaxCpuFrequency()).append(System.getProperty(
          "\n"));
      sb.append("Max virtual Cores: ").append(cpu.getVirtualCores()).append(System.getProperty("\n"));
    }
    if (AssertionUtils.isNotNull(result.getMemory())) {
      Memory mem = result.getMemory();
      sb.append("//======= Memory INFORMATION =======//").append(System.getProperty("\n"));
      sb.append("Free Memory Name: ").append(mem.getFreeMemSize()).append(System.getProperty("\n"));
      sb.append("Used Memory: ").append(mem.getUsedMemSize()).append(System.getProperty("\n"));
      sb.append("Total Memory: ").append(mem.getMaxMemSize()).append(System.getProperty("\n"));
    }
    if (AssertionUtils.isNotNull(result.getStorage())) {
      Storage disk = result.getStorage();
      sb.append("//======= Storage INFORMATION =======//").append(System.getProperty("\n"));
      /*sb.append("Free Memory Name: ").append(mem.getFreeMemSize());
      sb.append("Used Memory: ").append(mem.getUsedMemSize());
      sb.append("Total Memory: ").append(mem.getMaxMemSize());*/
    }
    if (AssertionUtils.isNotNull(result.getNetwork())) {
      Network net = result.getNetwork();
      sb.append("//======= Network INFORMATION =======//").append(System.getProperty("\n"));
      sb.append("Domain: ").append(net.getDomainName()).append(System.getProperty("\n"));
      sb.append("Hostname: ").append(net.getHostname()).append(System.getProperty("\n"));
      sb.append("Public IP: ").append(net.getIpAdress()).append(System.getProperty("\n"));
      sb.append("Mac Adresse ").append(net.getMacAdress()).append(System.getProperty("\n"));
      sb.append("Subnetmask ").append(net.getSubnet()).append(System.getProperty("\n"));
    }
    if (AssertionUtils.isNotNull(result.getHardware())) {
      Hardware hard = result.getHardware();
      sb.append("//======= Hardware INFORMATION =======//").append(System.getProperty("\n"));
    }
    if (AssertionUtils.isNotNull(result.getOs())) {
      Os os = result.getOs();
      sb.append("//======= Operating System INFORMATION =======//").append(System.getProperty("\n"));
      sb.append("Name: ").append(os.getName()).append(System.getProperty("\n"));
      sb.append("Version: ").append(os.getVersion()).append(System.getProperty("\n"));
      sb.append("Architecture: ").append(os.getArchitecture()).append(System.getProperty("\n"));
    }
    if (AssertionUtils.isNotNull(result.getJvm())) {
      Jvm jvm = result.getJvm();
      sb.append("//======= Java Virtual Machine INFORMATION =======//").append(System.getProperty("\n"));
      sb.append("Java VM Name: ").append(jvm.getJavaVMName()).append(System.getProperty("\n"));
      sb.append("Java VM Version: ").append(jvm.getJavaVMVersion()).append(System.getProperty("\n"));
      sb.append("Java VM Spec: ").append(jvm.getJavaVMSpec()).append(System.getProperty("\n"));

      sb.append("Java Runtime Name: ").append(jvm.getJavaRuntimeName()).append(System.getProperty("\n"));
      sb.append("Java Runtime Version: ").append(jvm.getJavaRuntimeVersion()).append(System.getProperty("\n"));

      sb.append("Java Version: ").append(jvm.getJavaVersion()).append(System.getProperty("\n"));
      sb.append("Java Class Version: ").append(jvm.getJavaClassVersion()).append(System.getProperty("\n"));

      sb.append("Java Home Path: ").append(jvm.getJavaHome()).append(System.getProperty("\n"));
      sb.append("Java Tmp Dir: ").append(jvm.getJavaTmpDir()).append(System.getProperty("\n"));
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
