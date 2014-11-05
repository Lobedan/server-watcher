package de.server.watcher.base.service;

import java.util.List;

import de.server.watcher.base.report.AbstractReporter;

/**
 * Created by svenklemmer on 04.11.14.
 */
public interface ReporterService {
  public void execute() throws Exception;

  public List<AbstractReporter> getReporter();
  public void setReporter(List<AbstractReporter> aReporter);
}
