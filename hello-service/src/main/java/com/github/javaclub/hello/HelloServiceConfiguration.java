package com.github.javaclub.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HelloServiceConfiguration {

  @Bean
  public RestTemplate restTesmplate() {
    return new RestTemplate();
  }
}
