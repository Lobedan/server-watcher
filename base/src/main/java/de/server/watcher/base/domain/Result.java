package de.server.watcher.base.domain;

import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * Holds all data of all objects
 */
public class Result {
  private static final Logger LOGGER = Logger.getLogger(Result.class);

  private Cpu cpu;
  private Memory memory;
  private Network network;
  private Storage storage;
}
