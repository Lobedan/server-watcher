package de.server.watcher.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 04.11.14.
 */
public class Cpu {
  private static final Logger LOGGER = Logger.getLogger(Cpu.class);

  private int cores;
  private int virtualCores;
  private String brand;

  private String maxCpuFrequency;
  private String cpuFrequency;
  private boolean bit64;

  private String architecture;

  public Cpu() { }

  public String getArchitecture() {
    return architecture;
  }

  public Cpu setArchitecture(String aArchitecture) {
    architecture = aArchitecture;
    return this;
  }

  public boolean isBit64() {
    return bit64;
  }

  public Cpu setBit64(boolean aBit64) {
    bit64 = aBit64;
    return this;
  }

  public String getMaxCpuFrequency() {
    return maxCpuFrequency;
  }

  public Cpu setMaxCpuFrequency(String aMaxCpuFrequency) {
    maxCpuFrequency = aMaxCpuFrequency;
    return this;
  }

  public String getCpuFrequency() {
    return cpuFrequency;
  }

  public Cpu setCpuFrequency(String aCpuFrequency) {
    cpuFrequency = aCpuFrequency;
    return this;
  }

  public int getVirtualCores() {
    return virtualCores;
  }

  public Cpu setVirtualCores(int aVirtualCores) {
    virtualCores = aVirtualCores;
    return this;
  }

  public String getBrand() {
    return brand;
  }

  public Cpu setBrand(String aBrand) {
    brand = aBrand;
    return this;
  }

  public int getCores() {
    return cores;
  }

  public Cpu setCores(int aCores) {
    cores = aCores;
    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("cores", cores)
        .append("virtualCores", virtualCores)
        .append("brand", brand)
        .append("maxCpuFrequency", maxCpuFrequency)
        .append("cpuFrequency", cpuFrequency)
        .append("bit64", bit64)
        .toString();
  }
}
