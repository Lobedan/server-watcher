package de.server.watcher.base.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.server.watcher.base.detector.AbstractDetector;

/**
 * Created by svenklemmer on 06.11.14.
 */
@Service(value = "defaultDetectorService")
public class DefaultDetectorService implements DetectorService {
  private static final Logger LOGGER = Logger.getLogger(DefaultDetectorService.class);

  private List<AbstractDetector> detectors;

  public void execute() throws Exception {
    for (AbstractDetector a : detectors) {
      a.detect();
    }
  }

  @Autowired
  public void setDetectors(List<AbstractDetector> aDetectors) {
    detectors = aDetectors;
  }

  public List<AbstractDetector> getDetectors() {
    return detectors;
  }
}

