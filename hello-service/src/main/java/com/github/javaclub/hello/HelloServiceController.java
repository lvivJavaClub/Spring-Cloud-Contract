package com.github.javaclub.hello;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
class HelloServiceController {

  private final RestTemplate restTemplate;

  @RequestMapping("/message/{personId}")
  public String getMessage(@PathVariable("personId") Long personId) {
    Person person = this.restTemplate.getForObject("http://localhost:8000/person/{personId}", Person.class, personId);
    return "Hello " + person.getName();
  }
}
