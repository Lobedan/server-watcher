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
    Jvm jvm = new Jvm();

    Result r = DetectorResultMetaHolder.instance().get();
    r.setJvm(jvm);
  }
}
