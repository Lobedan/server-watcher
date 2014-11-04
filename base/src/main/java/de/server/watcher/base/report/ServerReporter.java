package de.server.watcher.base.report;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * service to send reports to server-watcher-server
 * available in spring context
 */
@Service(value = "server")
public class ServerReporter extends AbstractReporter {
  private static final Logger LOGGER = Logger.getLogger(ServerReporter.class);

  @Override
  public void prepare() {

  }

  @Override
  public void send() {

  }
}
