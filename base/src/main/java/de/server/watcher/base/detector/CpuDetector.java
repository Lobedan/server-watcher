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
      cpu
          .setBrand(propertiesMap.get("model name"))
          .setCores(Integer.valueOf(propertiesMap.get("Core(s) per socket")))
          .setVirtualCores(cpu.getCores())
          .setCpuFrequency(convertMhzToGHz(propertiesMap.get("CPU MHz")))
          .setMaxCpuFrequency(cpu.getCpuFrequency())
          .setBit64((propertiesMap.get("CPU op-mode(s)").contains("64")))
          .setArchitecture(propertiesMap.get("Architecture"));
    }
    LOGGER.info(cpu);

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

  /*

-- listing properties --
java.runtime.name=Java(TM) SE Runtime Environment
sun.boot.library.path=/Library/Java/JavaVirtualMachines/jdk...
java.vm.version=24.45-b08
gopherProxySet=false
java.vm.vendor=Oracle Corporation
java.vendor.url=http://java.oracle.com/
path.separator=:
java.vm.name=Java HotSpot(TM) 64-Bit Server VM
file.encoding.pkg=sun.io
idea.launcher.port=7536
user.country=DE
sun.java.launcher=SUN_STANDARD
sun.os.patch.level=unknown
java.vm.specification.name=Java Virtual Machine Specification
user.dir=/Users/svenklemmer/Development/server...
java.runtime.version=1.7.0_45-b18
java.awt.graphicsenv=sun.awt.CGraphicsEnvironment
java.endorsed.dirs=/Library/Java/JavaVirtualMachines/jdk...
os.arch=x86_64
java.io.tmpdir=/var/folders/cb/015cgh3s78d_5cctdnv65...
line.separator=

java.vm.specification.vendor=Oracle Corporation
os.name=Mac OS X
sun.jnu.encoding=UTF-8
java.library.path=/Users/svenklemmer/Library/Java/Exten...
java.specification.name=Java Platform API Specification
java.class.version=51.0
sun.management.compiler=HotSpot 64-Bit Tiered Compilers
os.version=10.10
http.nonProxyHosts=local|*.local|169.254/16|*.169.254/16
user.home=/Users/svenklemmer
user.timezone=Europe/Berlin
java.awt.printerjob=sun.lwawt.macosx.CPrinterJob
java.specification.version=1.7
file.encoding=UTF-8
idea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Co...
user.name=svenklemmer
java.class.path=/Applications/IntelliJ IDEA 14.app/Co...
java.vm.specification.version=1.7
sun.arch.data.model=64
java.home=/Library/Java/JavaVirtualMachines/jdk...
sun.java.command=com.intellij.rt.execution.application...
java.specification.vendor=Oracle Corporation
user.language=de
awt.toolkit=sun.lwawt.macosx.LWCToolkit
java.vm.info=mixed mode
java.version=1.7.0_45
java.ext.dirs=/Users/svenklemmer/Library/Java/Exten...
sun.boot.class.path=/Library/Java/JavaVirtualMachines/jdk...
java.vendor=Oracle Corporation
file.separator=/
java.vendor.url.bug=http://bugreport.sun.com/bugreport/
sun.cpu.endian=little
sun.io.unicode.encoding=UnicodeBig
socksNonProxyHosts=local|*.local|169.254/16|*.169.254/16
ftp.nonProxyHosts=local|*.local|169.254/16|*.169.254/16
sun.cpu.isalist=
Total CPU:4
Max Memory:1908932608
available Memory:112329576
os.name=Mac OS X


  */
}
