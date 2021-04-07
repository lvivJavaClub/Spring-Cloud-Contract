package com.github.javaclub.person;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
class PersonService {

  private final Map<Long, Person> personMap;

  public PersonService() {
    personMap = new HashMap<>();
    personMap.put(1L, new Person(1L, "Ivan", "Shevtsov"));
    personMap.put(2L, new Person(2L, "Serge", "Bishyr"));
    personMap.put(3L, new Person(3L, "Ihor", "Banadiga", 69));
    personMap.put(4L, new Person(4L, "Ivan", "Verhun"));
  }

  Person findPersonById(Long id) {
    return personMap.get(id);
  }
}
