package de.server.watcher.server;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.server.watcher.base.domain.Result;

/**
 * Created by svenklemmer on 04.11.14.
 */
@RestController
public class ReportController {
  private static final Logger LOGGER = Logger.getLogger(ReportController.class);

  /**
   * Received Resultobject from a server-watcher-client and stores information
   * inside database
   * TODO: make dashboard for lookup
   *
   * @param payload
   * @return
   * @throws Exception
   */
  @RequestMapping(
      value = "/receive",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.PUT,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public HttpStatus receive(Result payload) throws Exception {

    return HttpStatus.ACCEPTED;
  }
}
