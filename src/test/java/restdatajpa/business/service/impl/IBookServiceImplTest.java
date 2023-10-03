package restdatajpa.business.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import restdatajpa.domain.entity.BookEntity;

import java.time.LocalDate;

class IBookServiceImplTest {

    @Test
    void calculatePrice() {
        IBookServiceImpl calculator = new IBookServiceImpl();
        BookEntity bookEntity = new BookEntity(null,
                                               "El señor de los anillos",
                                               "author",
                                               LocalDate.now(),
                                               600,
                                               325.99,
                                               true);
        double price = calculator.calculatePrice(bookEntity);
        Assertions.assertTrue(price > 0);
        Assertions.assertEquals(343.98,
                                price);
    }
}