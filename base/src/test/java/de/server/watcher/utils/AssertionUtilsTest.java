package de.server.watcher.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 06.11.14.
 */
@RunWith(JUnit4.class)
public class AssertionUtilsTest {

  @Test
  public void testCanTestIfNotNull() throws Exception {
    String string = "hi";
    String nullString = null;
    Object obj = new Object();
    Object nullObject = null;

    assertThat(AssertionUtils.isNotNull(string), is(true));
    assertThat(AssertionUtils.isNotNull(nullString), is(false));
    assertThat(AssertionUtils.isNotNull(obj), is(true));
    assertThat(AssertionUtils.isNotNull(nullObject), is(false));
  }

  @Test
  public void testCanTestIfNull() throws Exception {
    String string = "hi";
    String nullString = null;
    Object obj = new Object();
    Object nullObject = null;

    assertThat(AssertionUtils.isNull(string), is(false));
    assertThat(AssertionUtils.isNull(nullString), is(true));
    assertThat(AssertionUtils.isNull(obj), is(false));
    assertThat(AssertionUtils.isNull(nullObject), is(true));
  }
}
