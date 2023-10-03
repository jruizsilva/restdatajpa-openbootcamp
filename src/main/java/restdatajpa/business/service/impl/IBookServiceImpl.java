package restdatajpa.business.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restdatajpa.business.service.IBookService;
import restdatajpa.domain.entity.BookEntity;
import restdatajpa.persistence.IBookRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class IBookServiceImpl implements IBookService {
    private final IBookRepository iBookRepository;

    @Override
    public List<BookEntity> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public BookEntity findById(Long id) {
        Optional<BookEntity> bookEntityOptional = iBookRepository.findById(id);
        if (bookEntityOptional.isEmpty()) {
            throw new RuntimeException("Book not found");
        }
        return bookEntityOptional.get();
    }

    @Override
    public BookEntity create(BookEntity bookEntity) {
        return iBookRepository.save(bookEntity);
    }

    @Override
    public BookEntity update(BookEntity bookEntity) {
        return iBookRepository.save(bookEntity);
    }

    @Override
    public void deleteById(Long id) {
        Optional<BookEntity> bookEntityOptional = iBookRepository.findById(id);
        if (bookEntityOptional.isEmpty()) {
            throw new RuntimeException("No existe un libro con ese id");
        }
        iBookRepository.deleteById(id);
    }

    public Double calculatePrice(restdatajpa.domain.entity.BookEntity bookEntity) {
        double price = bookEntity.getPrice();

        if (bookEntity.getPages() > 50) {
            price += 5;
        }
        price += 12.99;

        return price;
    }
}
