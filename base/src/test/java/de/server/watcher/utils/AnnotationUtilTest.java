package de.server.watcher.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.server.watcher.base.annotation.Reporter;
import de.server.watcher.base.annotation.ScheduledTask;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 04.11.14.
 */
@RunWith(JUnit4.class)
public class AnnotationUtilTest {
  private static final Logger LOGGER = Logger.getLogger(AnnotationUtilTest.class);

  @Test
  public void testCanDetectMultipleAnnotatedClasses() throws Exception {
    List<Class> classes = AnnotationUtil.getAnnotatedClasses("de.server.watcher.base.detector");
    assertThat(classes.size(), is(7));
    LOGGER.debug("Detected Classes " + classes);
  }

  @Test
  public void testCanDetectSpecificAnnotation() throws Exception {
    List<Class> classes = AnnotationUtil.getAnnotatedClasses("de.server.watcher.base.tasks",
                                                             ScheduledTask.class);
    assertThat(classes.size(), is(1));
    LOGGER.info("Detected Classes " + classes);
  }

  @Test
  public void testCanDetectSpecificAnnotationInMultipleClasses() throws Exception {
    List<Class> classes = AnnotationUtil.getAnnotatedClasses("de.server.watcher.base.report", Reporter.class);
    assertThat(classes.size(), is(4));
    LOGGER.info("Detected Classes " + classes);
  }
}
