package restdatajpa.presentation.controller;

import org.assertj.core.util.Arrays;
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
import restdatajpa.domain.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {
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

    private List<BookEntity> parseList(List<Object> objectList) {
        List<BookEntity> books = new ArrayList<>();
        for (Object object : objectList) {
            if (object instanceof BookEntity) {
                books.add((BookEntity) object);
            }
        }
        return books;
    }

    @Test
    void findAll() {
        ResponseEntity<BookEntity[]> response = testRestTemplate.getForEntity("/books",
                                                                              BookEntity[].class);
        List<Object> responseObjectList = Arrays.asList(response.getBody());
        List<BookEntity> bookEntityList = parseList(responseObjectList);

        Assertions.assertEquals(HttpStatus.OK,
                                response.getStatusCode());
        Assertions.assertEquals(5,
                                bookEntityList.size());
    }

    @Test
    void findById() {
    }

    @Test
    void create() {
    }
}