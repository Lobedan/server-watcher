package de.server.watcher.base.tasks;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import de.server.watcher.base.annotation.ScheduledTask;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * CollectorService is the main part of this application
 * it collects all data with {@link de.server.watcher.base.detector.AbstractDetector} extending
 * classes (annotated with {@link de.server.watcher.base.annotation.Detector})
 * detectors are called via the {@link de.server.watcher.base.service.DetectorService}
 *
 * and sends them with {@link de.server.watcher.base.report.AbstractReporter} implementing classes
 * to the endpoints (annotated with {@link de.server.watcher.base.annotation.Reporter}
 */
@EnableScheduling
@ScheduledTask
public class CollectorService {
  private static final Logger LOGGER = Logger.getLogger(CollectorService.class);

  @Scheduled(fixedRate = 30 * 1000)
  public void collectData() {

  }
}
