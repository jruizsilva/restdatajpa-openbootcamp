package restdatajpa.business.service;

import restdatajpa.domain.entity.BookEntity;

import java.util.List;

public interface IBookService {
    List<BookEntity> findAll();
    BookEntity findById(Long id);
    BookEntity create(BookEntity bookEntity);
    BookEntity update(BookEntity bookEntity);
    void deleteById(Long id);
}
