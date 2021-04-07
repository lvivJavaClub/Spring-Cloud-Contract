package com.github.javaclub.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
class Person {
  private final Long id;

  private final String name;

  private final String surname;
  
  private Integer age;
}
