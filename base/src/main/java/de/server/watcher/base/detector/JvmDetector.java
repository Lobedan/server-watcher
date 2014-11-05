package de.server.watcher.base.detector;

import org.apache.log4j.Logger;

import de.server.watcher.base.annotation.Detector;
import de.server.watcher.base.domain.Jvm;
import de.server.watcher.base.domain.Result;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;

/**
 * Created by svenklemmer on 05.11.14.
 */
@Detector
public class JvmDetector extends AbstractDetector {
  private static final Logger LOGGER = Logger.getLogger(JvmDetector.class);

  @Override
  public void detect() {
    Result r = DetectorResultMetaHolder.instance().get();
    Jvm jvm = new Jvm();

    jvm
        .setJavaRuntimeName(System.getProperty("java.runtime.name"))
        .setJavaVMName(System.getProperty("java.vm.name"))

        .setJavaVersion(System.getProperty("java.version"))
        .setJavaRuntimeVersion(System.getProperty("java.runtime.version"))
        .setJavaVMVersion(System.getProperty("java.vm.version"))

        .setJavaTmpDir(System.getProperty("java.io.tmpdir"))
        .setJavaClassVersion(System.getProperty("java.class.version"))
        .setJavaVMSpec(System.getProperty("java.vm.specification.version"))
        .setJavaHome(System.getProperty("java.home"));

    LOGGER.debug("Detected JVM Information: " + jvm);
    r.setJvm(jvm);
  }
}
