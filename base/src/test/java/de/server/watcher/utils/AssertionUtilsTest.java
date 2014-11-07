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

  @Test
  public void testCanCheckTwoIntsEqual() throws Exception {
    int a = 1;
    int b = 1;
    assertThat((a == b), is(AssertionUtils.equal(a, b)));
  }

  @Test
  public void testCanCheckTwoObjectsEqual() throws Exception {
    Object a = new Object();
    Object b = a;
    assertThat((a.equals(b)), is(AssertionUtils.equal(a,b)));
  }

  @Test
  public void testCanCheckTwoIntsNotEqual() throws Exception {
    int a = 1;
    int b = 2;
    assertThat((a != b), is(AssertionUtils.notEqual(a, b)));
  }

  @Test
  public void testCanCheckTwoObjectsNotEqual() throws Exception {
    Object a = new Object();
    Object b = new Object();
    assertThat((!a.equals(b)), is(AssertionUtils.notEqual(a, b)));
  }

  @Test
  public void testCanCheckEqualityOfStrings() throws Exception {
    String a = "String a";
    String b = "String b";
    assertThat(!a.equals(b), is(AssertionUtils.notEqual(a, b)));
    assertThat(a.equals(a), is(AssertionUtils.equal(a, a)));
  }

  @Test
  public void testCanCheckEmptyStrings() throws Exception {
    String a = "";
    String b = "a";
    assertThat(a.isEmpty(), is(AssertionUtils.isEmpty(a)));
    assertThat(!b.isEmpty(), is(AssertionUtils.isNotEmpty(b)));
  }
}
