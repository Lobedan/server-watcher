package de.server.watcher.base.detector;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.server.watcher.base.domain.Network;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 06.11.14.
 */
@RunWith(JUnit4.class)
public class NetworkDetectorTest {
  private static final Logger LOGGER = Logger.getLogger(NetworkDetectorTest.class);

    private NetworkDetector detector;
    private DetectorResultMetaHolder holder;

    @Before
    public void setup() {
      detector = new NetworkDetector();
      holder = DetectorResultMetaHolder.recreate();
    }

    @Test
    public void testCanDetectMemory() throws Exception {
      detector.detect();

      assertThat(holder.get(), is(notNullValue()));
      Network net = holder.get().getNetwork();
      assertThat(net, is(notNullValue()));
    }
  }
