package de.server.watcher.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 04.11.14.
 */
public class Memory {
  private static final Logger LOGGER = Logger.getLogger(Memory.class);

  private String maxMemSize;
  private String usedMemSize;
  private String freeMemSize;

  public Memory() {
  }

  public String getFreeMemSize() {
    return freeMemSize;
  }

  public Memory setFreeMemSize(String aFreeMemSize) {
    freeMemSize = aFreeMemSize;
    return this;
  }

  public String getMaxMemSize() {
    return maxMemSize;
  }

  public Memory setMaxMemSize(String aMaxMemSize) {
    maxMemSize = aMaxMemSize;
    return this;
  }

  public String getUsedMemSize() {
    return usedMemSize;
  }

  public Memory setUsedMemSize(String aUsedMemSize) {
    usedMemSize = aUsedMemSize;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Memory memory = (Memory) o;

    if (freeMemSize != null ? !freeMemSize.equals(memory.freeMemSize) : memory.freeMemSize != null) {
      return false;
    }
    if (maxMemSize != null ? !maxMemSize.equals(memory.maxMemSize) : memory.maxMemSize != null) {
      return false;
    }
    if (usedMemSize != null ? !usedMemSize.equals(memory.usedMemSize) : memory.usedMemSize != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = maxMemSize != null ? maxMemSize.hashCode() : 0;
    result = 31 * result + (usedMemSize != null ? usedMemSize.hashCode() : 0);
    result = 31 * result + (freeMemSize != null ? freeMemSize.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("maxMemSize", maxMemSize)
        .append("usedMemSize", usedMemSize)
        .append("freeMemSize", freeMemSize)
        .toString();
  }
}
