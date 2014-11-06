/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.detector;

import java.util.Map;

import org.apache.log4j.Logger;

import de.server.watcher.base.annotation.Detector;
import de.server.watcher.base.domain.Network;
import de.server.watcher.base.domain.DetectorResult;
import de.server.watcher.base.metaholder.DetectorResultMetaHolder;

/**
 * Created by svenklemmer on 04.11.14.
 */
@Detector
public class NetworkDetector extends AbstractDetector {
  private static final Logger LOGGER = Logger.getLogger(NetworkDetector.class);

  @Override
  public void detect() throws Exception {
    DetectorResult r = DetectorResultMetaHolder.instance().get();
    Network net = new Network();

    Map<String, String> propertiesMap;

    String osName = System.getProperty("os.name");
    if (osName.contains("Mac")) {
      propertiesMap = super.watchMacNetwork();

      net
          .setIpAdress(propertiesMap.get("server_identifier (ip)"))
          .setSubnet(propertiesMap.get("subnet_mask"))
          .setHostname(propertiesMap.get("hostname"))
          .setDomainName(propertiesMap.get("domain_name (string)"))
          .setMacAdress(propertiesMap.get("chaddr"));
    } else if (osName.contains("Windows")) {
      propertiesMap = super.watchWindows();
      //TODO: detect properties on windows
    } else {
      propertiesMap = super.watchLinux();
    }
    LOGGER.debug("Detected Network Information: " + net);
    r.setNetwork(net);
  }
}
