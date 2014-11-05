/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.metaholder;

import org.springframework.context.annotation.Scope;

import de.server.watcher.base.domain.Result;

/**
 * Created by svenklemmer on 04.11.14.
 *
 * Singleton to hold only one instance of results
 *
 * it holts the {@link de.server.watcher.base.domain.Result} object
 * while collecting data
 */
@Scope(value = "singleton")
public class DetectorResultMetaHolder {
  private static DetectorResultMetaHolder unique;

  private Result result;

  /**
   * private constructor to prevent creating new instance
   */
  private DetectorResultMetaHolder() { }

  /**
   * if there is no instance available create a new one
   * @return the only existing instance
   */
  public static DetectorResultMetaHolder instance() {
    if (unique == null) {
      unique = new DetectorResultMetaHolder();
    }
    return unique;
  }

  /**
   * @return existing result object
   */
  public Result get() {
    return result;
  }

  /**
   * Set result object instead of existing one
   * @param res result object to set
   */
  public void set(Result res) {
    this.result = res;
  }

  /**
   * Merges two {@link de.server.watcher.base.domain.Result} objects, checks if there fields are equal
   * if they are then check category, decide which to choose and store it
   * if thery are not then insert missing fields to a new object
   *
   * @param res to merge into holding result object
   * @return merged Result object
   */
  public Result merge (Result res) {
    return new Result();
  }

  /**
   * clears result object
   * and allocates a new one
   */
  public void clear() {
    result = null;
    result = new Result();
  }

  /**
   * deletes existing instance if one exists
   * otherwise make new one
   *
   * @return new created instance
   */
  public static DetectorResultMetaHolder recreate() {
    if (unique != null) {
      unique = null;
    }
    return instance();
  }
}
