package com.github.javaclub.person;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
class PersonRestController {

  private final PersonService personService;

  @GetMapping("/person/{id}")
  public Person findPersonById(@PathVariable("id") Long id) {
    return personService.findPersonById(id);
  }
}
