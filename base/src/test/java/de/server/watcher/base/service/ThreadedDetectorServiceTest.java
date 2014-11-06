package de.server.watcher.base.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.server.watcher.BaseApplication;
import de.server.watcher.base.detector.AbstractDetector;
import de.server.watcher.base.detector.CpuDetector;
import de.server.watcher.base.detector.OsDetector;

/**
 * Created by svenklemmer on 04.11.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BaseApplication.class)
public class ThreadedDetectorServiceTest {

  @Autowired
  private DetectorService service;

  @Test
  public void testCanRunAllDetectors() throws Exception {
    service.execute();
  }

  @Test
  public void testCanSetDifferentDetectors() throws Exception {
    List<AbstractDetector> l = new ArrayList<AbstractDetector>();
    l.add(new CpuDetector());
    l.add(new OsDetector());

    service.setDetectors(l);
    service.execute();
  }
}
