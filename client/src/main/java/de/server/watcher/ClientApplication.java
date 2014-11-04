package de.server.watcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by svenklemmer on 03.11.14.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ClientApplication extends SpringBootServletInitializer {

  //CHECKSTYLE:OFF
  public static void main(String[] args) throws Exception {
    SpringApplication.run(ClientApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(ClientApplication.class);
  }
  //CHECKSTYLE:ON
}
