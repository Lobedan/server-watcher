/*
 * This document contains trade secret data which is the property of
 * Ippen Digital GmbH & Co. KG. Information contained herein may not be
 * used, copied or disclosed in whole or part except as permitted by
 * written agreement from Ippen Digital GmbH & Co. KG.
 *
 * Copyright (C) 2007-2008 Ippen Digital GmbH & Co. KG / Munich / Germany
 */
package de.server.watcher.base.metaholder;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.annotation.Scope;

import de.server.watcher.base.domain.DetectorResult;

/**
 * Created by svenklemmer on 04.11.14.
 * <p/>
 * Singleton to hold only one instance of results
 * <p/>
 * it holts the {@link de.server.watcher.base.domain.DetectorResult} object
 * while collecting data
 */
@Scope(value = "singleton")
public final class DetectorResultMetaHolder {
  private static DetectorResultMetaHolder unique;

  private DetectorResult detectorResult;

  /**
   * private constructor to prevent creating new instance
   */
  private DetectorResultMetaHolder() {
    detectorResult = new DetectorResult();
  }

  /**
   * if there is no instance available create a new one
   *
   * @return the only existing instance
   */
  public static DetectorResultMetaHolder instance() {
    if (unique == null) {
      unique = new DetectorResultMetaHolder();
    }
    return unique;
  }

  /**
   * @return existing detectorresult object
   */
  public DetectorResult get() {
    return detectorResult;
  }

  /**
   * Set DetectorResult object instead of existing one
   *
   * @param aDetectorResult result object to set
   */
  public void set(DetectorResult aDetectorResult) {
    detectorResult = aDetectorResult;
  }

  /**
   * Merges two {@link de.server.watcher.base.domain.DetectorResult} objects, checks if there fields are equal
   * if they are then check category, decide which to choose and store it
   * if thery are not then insert missing fields to a new object
   *
   * @param res to merge into holding result object
   * @return merged Result object
   */
  public DetectorResult merge(DetectorResult res) {
    return new DetectorResult();
  }

  /**
   * clears result object
   * and allocates a new one
   */
  public void clear() {
    detectorResult = null;
    detectorResult = new DetectorResult();
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

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("DetectorResult", detectorResult)
        .toString();
  }
}
