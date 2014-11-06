package de.server.watcher.utils;

import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 06.11.14.
 */
public class AssertionUtils {
  private static final Logger LOGGER = Logger.getLogger(AssertionUtils.class);

  /**
   * Checks if object is not null
   * @param object to check
   * @return true if not, otherwise false
   */
  public static boolean isNotNull(Object object) {
    if (object == null) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * checks if object is null
   * @param object to check
   * @return false if not, otherwise true
   */
  public static boolean isNull(Object object) {
    if (object == null) {
      return true;
    } else {
      return false;
    }
  }
}
