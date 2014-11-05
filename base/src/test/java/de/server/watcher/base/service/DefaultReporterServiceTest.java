package de.server.watcher.base.service;

import java.util.List;

import com.google.common.collect.Lists;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.server.watcher.BaseApplication;
import de.server.watcher.base.report.AbstractReporter;
import de.server.watcher.base.report.ConsoleReporter;

/**
 * Created by svenklemmer on 05.11.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BaseApplication.class)
public class DefaultReporterServiceTest {
  private static final Logger LOGGER = Logger.getLogger(DefaultReporterServiceTest.class);

  @Autowired
  private ReporterService service;

  @Test
  public void testCanRunAllDetectors() throws Exception {
    service.execute();
  }

  @Test
  public void testCanSetDifferentDetectors() throws Exception {
    List<AbstractReporter> l = Lists.newArrayList();
    l.add(new ConsoleReporter());

    service.setReporter(l);
    service.execute();
  }
}
