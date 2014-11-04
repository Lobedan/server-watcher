package de.server.watcher.base;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by svenklemmer on 04.11.14.
 */
@EnableScheduling
public class Collector {
  private static final Logger LOGGER = Logger.getLogger(Collector.class);

  @Scheduled(fixedRate = 30*1000)
  public void collect() {

  }
}
