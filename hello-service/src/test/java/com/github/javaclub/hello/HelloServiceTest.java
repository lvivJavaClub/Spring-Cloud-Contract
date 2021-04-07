package com.github.javaclub.hello;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(classes = HelloServiceApplication.class)
@AutoConfigureMockMvc
@Disabled
class HelloServiceTest {
  protected MockMvc mockMvc;
  @Autowired
  private WebApplicationContext context;

  @BeforeEach
  void beforeEachMockMvc() {
    mockMvc = MockMvcBuilders
        .webAppContextSetup(context)
        .alwaysDo(print())
        .build();
    RestAssuredMockMvc.mockMvc(mockMvc);
  }

  @Test
  void get_hello() {
    // given:
    MockMvcRequestSpecification request = given();


    // when:
    ResponseOptions response = given().spec(request)
        .get("/message/1");

    // then:
    assertThat(response.statusCode()).isEqualTo(200);
    assertThat(response.header("Content-Type")).matches("text/plain;charset=UTF-8");

    // and:
    assertThat(response.getBody().asString()).isEqualTo("Hello Ivan");
  }
}
