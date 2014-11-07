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
    return (object != null);
  }

  /**
   * checks if object is null
   * @param object to check
   * @return false if not, otherwise true
   */
  public static boolean isNull(Object object) {
    return (object == null);
  }

  /**
   * assert if two int are equal
   *
   * @param a first int
   * @param b second int
   * @return true if equal, otherwise false
   */
  public static boolean equal(int a, int b) {
    return (a == b);
  }

  /**
   * assert if two objects are equal using there #equals method
   *
   * @param a first object
   * @param b second object
   * @return true if equal otherwise false
   */
  public static boolean equal(Object a, Object b) {
    return (a.equals(b));
  }

  /**
   * assert if two string are equal using there #equals method
   *
   * @param a first string
   * @param b second string
   * @return true if equal otherwise false
   */
  public static boolean equal(String a, String b) { return (a.equals(b)); }

  /**
   * assert if two integer are not equal
   *
   * @param a first int
   * @param b second int
   * @return true if not equal, otherwise false
   */
  public static boolean notEqual(int a, int b) {
    return !equal(a, b);
  }

  /**
   * assert if two objects are not equal
   *
   * @param a first object
   * @param b second object
   * @return true if not equal, otherwise false
   */
  public static boolean notEqual(Object a, Object b) {
    return !equal(a, b);
  }

  /**
   * assert if two strings are not equal
   *
   * @param a first string
   * @param b second string
   * @return true if not equal, otherwise false
   */
  public static boolean notEqual(String a, String b) { return !equal(a, b); }

  /**
   * assert if a string is empty
   * literally a strings length must be 0
   *
   * @param a string to check
   * @return true if empty otherwise false
   */
  public static boolean isEmpty(String a) { return a.isEmpty(); }

  /**
   * assert if a string is not empty
   * literally a strings length must be greater than 0
   *
   * @param a string to check
   * @return true if not empty otherwise false
   */
  public static boolean isNotEmpty(String a) { return !isEmpty(a); }
}
