package de.server.watcher.base.report;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import de.server.watcher.base.annotation.Reporter;
import de.server.watcher.base.domain.DetectorResult;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * service to send reports to server-watcher-server
 * available in spring context
 */
@Reporter
public class ServerReporter extends AbstractReporter {
  private static final Logger LOGGER = Logger.getLogger(ServerReporter.class);

  private DetectorResult result;

  @Override
  public void prepare() {
    result = DetectorResultMetaHolder.instance().get();
  }

  @Override
  public void sendReport() {

    RestTemplate restTemplate = new RestTemplate();
//    restTemplate.put();
    LOGGER.debug("send @ SendReporter");

  }
}
