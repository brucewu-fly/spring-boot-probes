package com.aliyun.springbootprobes;

import java.util.Collections;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Liveness {

  private static Map<String, String> alwaysOk = Collections.singletonMap("status", "OK");

  @GetMapping("/liveness")
  public Map<String, String> testLiveness() {
    return alwaysOk;
  }
}
