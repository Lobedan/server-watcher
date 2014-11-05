package de.server.watcher.base.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.server.watcher.base.report.AbstractReporter;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * Finds reporters annotated with {@link de.server.watcher.base.annotation.Reporter}
 * and runs there #void sendReport() method
 *
 * this method will send a message or data to there specified endpoint
 * because all of it is annotation and beandriven, its possible to make further
 * implementations :)
 */
@Service(value = "defaultReporter")
public class DefaultReporterService implements ReporterService {
  private static final Logger LOGGER = Logger.getLogger(DefaultReporterService.class);

  private List<AbstractReporter> reporter;

  @Override
  public void execute() throws Exception {
    for (final AbstractReporter a : reporter) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          LOGGER.info("Running in thread " + Thread.currentThread());
          a.prepare();
          a.sendReport();
        }
      }).start();
    }
  }

  public List<AbstractReporter> getReporter() {
    return reporter;
  }

  @Autowired
  public void setReporter(List<AbstractReporter> aReporter) {
    reporter = aReporter;
  }
}
