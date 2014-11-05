package de.server.watcher.utils;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by svenklemmer on 05.11.14.
 */
@RunWith(JUnit4.class)
public class CommandLineUtilsTest {
  private static final Logger LOGGER = Logger.getLogger(CommandLineUtilsTest.class);

  @Test
  public void testCanCaptureCommandLineOutput() throws Exception {
    String output = CommandLineUtils.execToString("ls");
    assertThat(output.length(), is(greaterThan(0)));
  }
}
