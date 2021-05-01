package com.github.javaclub.hello;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class PersonServiceTest {

  @RegisterExtension
  public final static StubRunnerExtension STUB_RUNNER = new StubRunnerExtension()
      .downloadStub("com.github.javaclub.person", "person-service", "0.0.1-SNAPSHOT", "stubs")
      .withPort(8100)
      .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

  @Test
  void get_person_from_service_contract() {
    // given:
    RestTemplate restTemplate = new RestTemplate();

    // when:
    ResponseEntity<com.github.javaclub.hello.Person> personResponseEntity = restTemplate.getForEntity("http://localhost:8100/person/1", com.github.javaclub.hello.Person.class);

    // then:
    BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
    BDDAssertions.then(personResponseEntity.getBody()).isNotNull();
    BDDAssertions.then(personResponseEntity.getBody().getId()).isEqualTo(1L);
    BDDAssertions.then(personResponseEntity.getBody().getName()).isEqualTo("Ivan");

  }
}
