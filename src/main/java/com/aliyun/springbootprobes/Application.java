package com.aliyun.springbootprobes;

import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  @RequestMapping("/")
  public String home() {
    return "Hello Docker World";
  }

  @RequestMapping("/render")
  public String render(@RequestParam(value = "name") String name) throws InterruptedException {
    LOGGER.info("Beginning render " + name);
    String result = doRender(name);
    LOGGER.info("The " + name + " has been rendered");
    return result;
  }

  private String doRender(String name) throws InterruptedException {
    Thread.sleep(1000 * ThreadLocalRandom.current().nextInt(40));
    return "Hello " + name;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
