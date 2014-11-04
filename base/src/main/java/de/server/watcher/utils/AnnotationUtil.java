package de.server.watcher.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.google.common.collect.Lists;

import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 04.11.14.
 * <p/>
 * utils to detect classes with given annotation
 */
public class AnnotationUtil {
  private static final Logger LOGGER = Logger.getLogger(AnnotationUtil.class);

  /**
   * Scans all classes accessible from the context class loader which belong
   * to the given package and subpackages.
   *
   * @param packageName The base package
   * @return The classes
   * @throws ClassNotFoundException
   * @throws IOException
   */
  public static List<Class> getAnnotatedClasses (String packageName) throws ClassNotFoundException, IOException {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    String path = packageName.replace('.', '/');
    Enumeration<URL> resources = classLoader.getResources(path);
    List<File> dirs = new ArrayList<File>();
    while (resources.hasMoreElements()) {
      URL resource = resources.nextElement();
      dirs.add(new File(resource.getFile()));
    }
    List<Class> classes = new ArrayList<Class>();
    for (File directory : dirs) {
      classes.addAll(findClasses(directory, packageName));
    }
    LOGGER.debug("founnd " + classes.size() + " annotated classes " + classes);
    return classes;
  }

  /**
   * Scans all classes accessible from the context class loader which belong
   * to the given package and subpackages for a given annotation
   *
   * @param packageName base package
   * @param annotation to search
   * @return found classes
   * @throws ClassNotFoundException
   * @throws IOException
   */
  public static List<Class> getAnnotatedClasses(String packageName, Class annotation) throws ClassNotFoundException, IOException {
    List<Class> classes = Lists.newArrayList(getAnnotatedClasses(packageName));
    List<Class> annotatedClasses = new ArrayList<Class>();

    for (Class c : classes) {
      LOGGER.debug("checking class " + c.getName() + " for annotation " + annotation.getName());
      annotatedClasses.add(org.springframework.core.annotation.AnnotationUtils.findAnnotationDeclaringClass(annotation, c));
    }
    LOGGER.debug("Found classes " + annotatedClasses);
    return annotatedClasses;
  }

  /**
   * Recursive method used to find all classes in a given directory and
   * subdirs.
   *
   * @param directory   The base directory
   * @param packageName The package name for classes found inside the base directory
   * @return The classes
   * @throws ClassNotFoundException
   */
  private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
    List<Class> classes = new ArrayList<Class>();
    if (!directory.exists()) {
      return classes;
    }
    File[] files = directory.listFiles();
    for (File file : files) {
      if (file.isDirectory()) {
        classes.addAll(findClasses(file, packageName + "." + file.getName()));
      } else if (file.getName().endsWith(".class")) {
        classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
      }
    }
    return classes;
  }
}
