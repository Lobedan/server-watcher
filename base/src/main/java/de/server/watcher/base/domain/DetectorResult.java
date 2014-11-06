package de.server.watcher.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by svenklemmer on 04.11.14.
 * <p/>
 * Holds all data from all objects
 */
public class DetectorResult {
  private Cpu cpu;
  private Hardware hardware;

  private Jvm jvm;

  private Memory memory;
  private Network network;

  private Os os;
  private Storage storage;

  public DetectorResult() {
  }

  public Jvm getJvm() {
    return jvm;
  }

  public void setJvm(Jvm aJvm) {
    jvm = aJvm;
  }

  public Cpu getCpu() {
    return cpu;
  }

  public void setCpu(Cpu aCpu) {
    cpu = aCpu;
  }

  public Hardware getHardware() {
    return hardware;
  }

  public void setHardware(Hardware aHardware) {
    hardware = aHardware;
  }

  public Memory getMemory() {
    return memory;
  }

  public void setMemory(Memory aMemory) {
    memory = aMemory;
  }

  public Network getNetwork() {
    return network;
  }

  public void setNetwork(Network aNetwork) {
    network = aNetwork;
  }

  public Os getOs() {
    return os;
  }

  public void setOs(Os aOs) {
    os = aOs;
  }

  public Storage getStorage() {
    return storage;
  }

  public void setStorage(Storage aStorage) {
    storage = aStorage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetectorResult detectorResult = (DetectorResult) o;

    if (cpu != null ? !cpu.equals(detectorResult.cpu) : detectorResult.cpu != null) {
      return false;
    }
    if (hardware != null ? !hardware.equals(detectorResult.hardware) : detectorResult.hardware != null) {
      return false;
    }
    if (jvm != null ? !jvm.equals(detectorResult.jvm) : detectorResult.jvm != null) {
      return false;
    }
    if (memory != null ? !memory.equals(detectorResult.memory) : detectorResult.memory != null) {
      return false;
    }
    if (network != null ? !network.equals(detectorResult.network) : detectorResult.network != null) {
      return false;
    }
    if (os != null ? !os.equals(detectorResult.os) : detectorResult.os != null) {
      return false;
    }
    if (storage != null ? !storage.equals(detectorResult.storage) : detectorResult.storage != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = cpu != null ? cpu.hashCode() : 0;
    result = 31 * result + (hardware != null ? hardware.hashCode() : 0);
    result = 31 * result + (jvm != null ? jvm.hashCode() : 0);
    result = 31 * result + (memory != null ? memory.hashCode() : 0);
    result = 31 * result + (network != null ? network.hashCode() : 0);
    result = 31 * result + (os != null ? os.hashCode() : 0);
    result = 31 * result + (storage != null ? storage.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("cpu", cpu)
        .append("hardware", hardware)
        .append("jvm", jvm)
        .append("memory", memory)
        .append("network", network)
        .append("os", os)
        .append("storage", storage)
        .toString();
  }
}
