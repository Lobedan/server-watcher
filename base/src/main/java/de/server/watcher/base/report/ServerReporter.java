package de.server.watcher.base.report;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import de.server.watcher.base.annotation.Reporter;
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

  private static final String SERVER_URL = "http://localhost:9090/receive";

  @Override
  public void prepare() { }

  @Override
  public void sendReport() {
    RestTemplate restTemplate = new RestTemplate();
    LOGGER.info("send data to server");
    LOGGER.info(DetectorResultMetaHolder.instance().get());
    try {
      HttpStatus status = restTemplate.postForObject(SERVER_URL, DetectorResultMetaHolder.instance().get(), HttpStatus.class);
      LOGGER.info("response: " + status);
    } catch (Exception e) {
      LOGGER.error("Server is not available");
    }
  }
}
