package restdatajpa.presentation.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private String port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port + "/api");
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void holaMundo() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/hello",
                                                                        String.class);
        Assertions.assertEquals(HttpStatus.OK,
                                response.getStatusCode());
        Assertions.assertEquals("Hola mundo xd",
                                response.getBody());
    }
}