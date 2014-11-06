package de.server.watcher.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import de.server.watcher.base.annotation.ScheduledTask;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;
import de.server.watcher.base.service.DetectorService;
import de.server.watcher.base.service.ReporterService;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * CollectorService is the main part of this application
 * it collects all data with {@link de.server.watcher.base.detector.AbstractDetector} extending
 * classes (annotated with {@link de.server.watcher.base.annotation.Detector})
 *
 * detectors are called via the {@link de.server.watcher.base.service.DetectorService} per default
 * but there exists a threaded detector as well
 *
 * and sends them with {@link de.server.watcher.base.report.AbstractReporter} implementing classes
 * to the endpoints (annotated with {@link de.server.watcher.base.annotation.Reporter}
 */
@EnableScheduling
@ScheduledTask
public class CollectorTask {
  private static final Logger LOGGER = Logger.getLogger(CollectorTask.class);

  @Autowired
  @Qualifier("defaultDetectorService")
  private DetectorService detectorService;

  @Autowired
  private ReporterService reporterService;

  @Scheduled(fixedRate = 60 * 1000)
  public void collectData() throws Exception {
    String actualDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
    LOGGER.info("Start to collect Data @" + actualDate);
    detectorService.execute();
    if (DetectorResultMetaHolder.instance().get() != null) {
      LOGGER.debug(DetectorResultMetaHolder.instance().get());
      LOGGER.info("Collected data successfully invoking reporters");
      reporterService.execute();
    }
  }
}