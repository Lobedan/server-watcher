package de.server.watcher.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 04.11.14.
 */
public class Network {
  private static final Logger LOGGER = Logger.getLogger(Network.class);

  private String ipAdress;
  private String subnet;
  private String hostname;
  private String domainName;
  private String macAdress;

  public Network() { }

  public String getIpAdress() {
    return ipAdress;
  }

  public Network setIpAdress(String aIpAdress) {
    ipAdress = aIpAdress;
    return this;
  }

  public String getSubnet() {
    return subnet;
  }

  public Network setSubnet(String aSubnet) {
    subnet = aSubnet;
    return this;
  }

  public String getHostname() {
    return hostname;
  }

  public Network setHostname(String aHostname) {
    hostname = aHostname;
    return this;
  }

  public String getDomainName() {
    return domainName;
  }

  public Network setDomainName(String aDomainName) {
    domainName = aDomainName;
    return this;
  }

  public String getMacAdress() {
    return macAdress;
  }

  public Network setMacAdress(String aMacAdress) {
    macAdress = aMacAdress;
    return this;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Network network = (Network) o;

    if (domainName != null ? !domainName.equals(network.domainName) : network.domainName != null) {
      return false;
    }
    if (hostname != null ? !hostname.equals(network.hostname) : network.hostname != null) {
      return false;
    }
    if (ipAdress != null ? !ipAdress.equals(network.ipAdress) : network.ipAdress != null) {
      return false;
    }
    if (macAdress != null ? !macAdress.equals(network.macAdress) : network.macAdress != null) {
      return false;
    }
    if (subnet != null ? !subnet.equals(network.subnet) : network.subnet != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = ipAdress != null ? ipAdress.hashCode() : 0;
    result = 31 * result + (subnet != null ? subnet.hashCode() : 0);
    result = 31 * result + (hostname != null ? hostname.hashCode() : 0);
    result = 31 * result + (domainName != null ? domainName.hashCode() : 0);
    result = 31 * result + (macAdress != null ? macAdress.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("ipAdress", ipAdress)
        .append("subnet", subnet)
        .append("hostname", hostname)
        .append("domainName", domainName)
        .append("macAdress", macAdress)
        .toString();
  }
}
