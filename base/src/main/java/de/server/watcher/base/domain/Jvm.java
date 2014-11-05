package de.server.watcher.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 05.11.14.
 */
public class Jvm {
  private static final Logger LOGGER = Logger.getLogger(Jvm.class);
  
  private String javaRuntimeName;
  private String javaVMName;
  
  private String javaVersion;
  private String javaRuntimeVersion;
  private String javaVMVersion;
  
  private String javaTmpDir;
  private String javaClassVersion;
  private String javaVMSpec;
  private String javaHome;

  public Jvm() { }

  public String getJavaRuntimeName() {
    return javaRuntimeName;
  }

  public Jvm setJavaRuntimeName(String aJavaRuntimeName) {
    javaRuntimeName = aJavaRuntimeName;
    return this;
  }

  public String getJavaVMName() {
    return javaVMName;
  }

  public Jvm setJavaVMName(String aJavaVMName) {
    javaVMName = aJavaVMName;
    return this;
  }

  public String getJavaVersion() {
    return javaVersion;
  }

  public Jvm setJavaVersion(String aJavaVersion) {
    javaVersion = aJavaVersion;
    return this;
  }

  public String getJavaRuntimeVersion() {
    return javaRuntimeVersion;
  }

  public Jvm setJavaRuntimeVersion(String aJavaRuntimeVersion) {
    javaRuntimeVersion = aJavaRuntimeVersion;
    return this;
  }

  public String getJavaVMVersion() {
    return javaVMVersion;
  }

  public Jvm setJavaVMVersion(String aJavaVMVersion) {
    javaVMVersion = aJavaVMVersion;
    return this;
  }

  public String getJavaTmpDir() {
    return javaTmpDir;
  }

  public Jvm setJavaTmpDir(String aJavaTmpDir) {
    javaTmpDir = aJavaTmpDir;
    return this;
  }

  public String getJavaClassVersion() {
    return javaClassVersion;
  }

  public Jvm setJavaClassVersion(String aJavaClassVersion) {
    javaClassVersion = aJavaClassVersion;
    return this;
  }

  public String getJavaVMSpec() {
    return javaVMSpec;
  }

  public Jvm setJavaVMSpec(String aJavaVMSpec) {
    javaVMSpec = aJavaVMSpec;
    return this;
  }

  public String getJavaHome() {
    return javaHome;
  }

  public Jvm setJavaHome(String aJavaHome) {
    javaHome = aJavaHome;
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

    Jvm jvm = (Jvm) o;

    if (javaClassVersion != null ? !javaClassVersion.equals(jvm.javaClassVersion) : jvm.javaClassVersion != null) {
      return false;
    }
    if (javaHome != null ? !javaHome.equals(jvm.javaHome) : jvm.javaHome != null) {
      return false;
    }
    if (javaRuntimeName != null ? !javaRuntimeName.equals(jvm.javaRuntimeName) : jvm.javaRuntimeName != null) {
      return false;
    }
    if (javaRuntimeVersion != null ?
        !javaRuntimeVersion.equals(jvm.javaRuntimeVersion) :
        jvm.javaRuntimeVersion != null) {
      return false;
    }
    if (javaTmpDir != null ? !javaTmpDir.equals(jvm.javaTmpDir) : jvm.javaTmpDir != null) {
      return false;
    }
    if (javaVMName != null ? !javaVMName.equals(jvm.javaVMName) : jvm.javaVMName != null) {
      return false;
    }
    if (javaVMSpec != null ? !javaVMSpec.equals(jvm.javaVMSpec) : jvm.javaVMSpec != null) {
      return false;
    }
    if (javaVMVersion != null ? !javaVMVersion.equals(jvm.javaVMVersion) : jvm.javaVMVersion != null) {
      return false;
    }
    if (javaVersion != null ? !javaVersion.equals(jvm.javaVersion) : jvm.javaVersion != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = javaRuntimeName != null ? javaRuntimeName.hashCode() : 0;
    result = 31 * result + (javaVMName != null ? javaVMName.hashCode() : 0);
    result = 31 * result + (javaVersion != null ? javaVersion.hashCode() : 0);
    result = 31 * result + (javaRuntimeVersion != null ? javaRuntimeVersion.hashCode() : 0);
    result = 31 * result + (javaVMVersion != null ? javaVMVersion.hashCode() : 0);
    result = 31 * result + (javaTmpDir != null ? javaTmpDir.hashCode() : 0);
    result = 31 * result + (javaClassVersion != null ? javaClassVersion.hashCode() : 0);
    result = 31 * result + (javaVMSpec != null ? javaVMSpec.hashCode() : 0);
    result = 31 * result + (javaHome != null ? javaHome.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("javaRuntimeName", javaRuntimeName)
        .append("javaVMName", javaVMName)
        .append("javaVersion", javaVersion)
        .append("javaRuntimeVersion", javaRuntimeVersion)
        .append("javaVMVersion", javaVMVersion)
        .append("javaTmpDir", javaTmpDir)
        .append("javaClassVersion", javaClassVersion)
        .append("javaVMSpec", javaVMSpec)
        .append("javaHome", javaHome)
        .toString();
  }
}
