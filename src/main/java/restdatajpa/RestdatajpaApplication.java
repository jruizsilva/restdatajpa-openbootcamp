package restdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestdatajpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestdatajpaApplication.class, args);
        /*IBookRepository iBookRepository = context.getBean(IBookRepository.class);

        BookEntity bookEntity1 = BookEntity.builder()
                                           .title("Harry Pother")
                                           .author("Yaval Noah")
                                           .pages(450)
                                           .price(29.99)
                                           .releaseDate(LocalDate.of(2018, 12, 5))
                                           .online(true)
                                           .build();
        BookEntity bookEntity2 = BookEntity.builder()
                                           .title("Harry Pother 2")
                                           .author("Yaval Noah")
                                           .pages(300)
                                           .price(50.99)
                                           .releaseDate(LocalDate.of(2022, 5, 5))
                                           .online(true)
                                           .build();

        iBookRepository.save(bookEntity1);
        iBookRepository.save(bookEntity2);

        List<BookEntity> bookEntityList = iBookRepository.findAll();
        System.out.println("Cantidad de libros: " + iBookRepository.count());
        System.out.println(bookEntityList);*/
    }

}
