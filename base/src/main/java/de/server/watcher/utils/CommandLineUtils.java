package de.server.watcher.utils;

import java.io.ByteArrayOutputStream;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 05.11.14.
 */
public class CommandLineUtils {
  private static final Logger LOGGER = Logger.getLogger(CommandLineUtils.class);

  /**
   * executes a command on commandline and caputures its output, as a string
   *
   * @param command to execute
   * @return outputstring
   * @throws Exception
   */
  public static String execToString(String command) throws Exception {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    CommandLine commandline = CommandLine.parse(command);
    DefaultExecutor exec = new DefaultExecutor();
    PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
    exec.setStreamHandler(streamHandler);
    exec.execute(commandline);
    return(outputStream.toString());
  }
}
