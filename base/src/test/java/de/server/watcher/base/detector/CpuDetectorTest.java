package de.server.watcher.base.detector;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.server.watcher.base.domain.Cpu;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 05.11.14.
 */
@RunWith(JUnit4.class)
public class CpuDetectorTest {
  private static final Logger LOGGER = Logger.getLogger(CpuDetectorTest.class);

  private CpuDetector cpuDetector;
  private DetectorResultMetaHolder holder;

  @Before
  public void setup() {
    cpuDetector = new CpuDetector();
    holder = DetectorResultMetaHolder.recreate();
  }

  @Test
  public void testCanDetectCpu() throws Exception {
    cpuDetector.detect();

    assertThat(holder.get(), is(notNullValue()));
    Cpu cpu = holder.get().getCpu();
    assertThat(cpu, is(notNullValue()));
    /*assertThat(cpu.getProcessor(), is())*/
  }



}
