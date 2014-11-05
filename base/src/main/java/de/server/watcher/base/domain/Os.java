/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 04.11.14.
 */
public class Os {
  private static final Logger LOGGER = Logger.getLogger(Os.class);

  private String name;
  private String version;
  private String architecture;

  public Os() { }

  public String getName() {
    return name;
  }

  public Os setName(String aName) {
    name = aName;
    return this;
  }

  public String getVersion() {
    return version;
  }

  public Os setVersion(String aVersion) {
    version = aVersion;
    return this;
  }

  public String getArchitecture() {
    return architecture;
  }

  public Os setArchitecture(String aArchitecture) {
    architecture = aArchitecture;
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

    Os os = (Os) o;

    if (architecture != null ? !architecture.equals(os.architecture) : os.architecture != null) {
      return false;
    }
    if (name != null ? !name.equals(os.name) : os.name != null) {
      return false;
    }
    if (version != null ? !version.equals(os.version) : os.version != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (version != null ? version.hashCode() : 0);
    result = 31 * result + (architecture != null ? architecture.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("name", name)
        .append("version", version)
        .append("architecture", architecture)
        .toString();
  }
}
