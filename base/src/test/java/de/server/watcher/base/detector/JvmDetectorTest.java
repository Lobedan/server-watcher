package de.server.watcher.base.detector;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.server.watcher.base.domain.Jvm;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 05.11.14.
 */
@RunWith(JUnit4.class)
public class JvmDetectorTest {
  private static final Logger LOGGER = Logger.getLogger(JvmDetectorTest.class);

  private JvmDetector detector;
  private DetectorResultMetaHolder holder;

  @Before
  public void setup() {
    detector = new JvmDetector();
    holder = DetectorResultMetaHolder.recreate();
  }

  @Test
  public void testCanDetectJVM() throws Exception {
    detector.detect();

    assertThat(holder.get(), is(notNullValue()));
    Jvm jvm = holder.get().getJvm();
    assertThat(jvm, is(notNullValue()));
    assertThat(jvm.getJavaVersion(), is(System.getProperty("java.version")));
    assertThat(jvm.getJavaHome(), is(System.getProperty("java.home")));
  }
}