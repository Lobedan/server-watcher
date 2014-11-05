package de.server.watcher.base.detector;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.server.watcher.base.domain.Os;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 05.11.14.
 */
@RunWith(JUnit4.class)
public class OsDetectorTest {
  private static final Logger LOGGER = Logger.getLogger(OsDetectorTest.class);

    private OsDetector detector;
    private DetectorResultMetaHolder holder;

    @Before
    public void setup() {
      detector = new OsDetector();
      holder = DetectorResultMetaHolder.recreate();
    }

    @Test
    public void testCanDetectOs() throws Exception {
      detector.detect();

      assertThat(holder.get(), is(notNullValue()));
      Os os = holder.get().getOs();
      assertThat(os, is(notNullValue()));
      assertThat(os.getName(), is(System.getProperty("os.name")));
      assertThat(os.getVersion(), is(System.getProperty("os.version")));
      assertThat(os.getArchitecture(), is(System.getProperty("os.arch")));
    }
  }
