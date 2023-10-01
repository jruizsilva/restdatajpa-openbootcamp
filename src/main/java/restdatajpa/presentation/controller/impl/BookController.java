package restdatajpa.presentation.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import restdatajpa.domain.entity.BookEntity;
import restdatajpa.persistence.IBookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@Validated
public class BookController {
    private final IBookRepository iBookRepository;

    @GetMapping
    public ResponseEntity<List<BookEntity>> findAll() {
        List<BookEntity> bookEntityList = iBookRepository.findAll();
        return ResponseEntity.ok(bookEntityList);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookEntity> findById(@PathVariable final Long bookId) {
        Optional<BookEntity> bookEntityOptional = iBookRepository.findById(bookId);
        return ResponseEntity.of(bookEntityOptional);
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody final BookEntity bookEntity) {
        Optional<BookEntity> bookEntityOptional = iBookRepository.findById(bookEntity.getId());
        if (bookEntityOptional.isPresent()) {
            iBookRepository.save(bookEntity);
            return ResponseEntity.noContent()
                                 .build();
        }
        return ResponseEntity.notFound()
                             .build();
    }

    @PostMapping
    public ResponseEntity<BookEntity> create(@Valid @RequestBody final BookEntity bookEntity) {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(iBookRepository.save(bookEntity));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteById(@PathVariable final Long bookId) {
        Optional<BookEntity> bookEntityOptional = iBookRepository.findById(bookId);
        bookEntityOptional.ifPresent(iBookRepository::delete);
        return ResponseEntity.noContent()
                             .build();
    }
}
