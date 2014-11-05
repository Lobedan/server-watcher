package de.server.watcher.base.report;

import org.apache.log4j.Logger;

import de.server.watcher.base.annotation.Reporter;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * service to send reports to server-watcher-server
 * available in spring context
 */
@Reporter
public class ServerReporter extends AbstractReporter {
  private static final Logger LOGGER = Logger.getLogger(ServerReporter.class);

  @Override
  public void prepare() {

  }

  @Override
  public void sendReport() {

  }
}
