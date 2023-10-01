package restdatajpa.presentation.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import restdatajpa.domain.entity.BookEntity;
import restdatajpa.persistence.IBookRepository;
import restdatajpa.presentation.controller.ICrudController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@Validated
public class BookController implements ICrudController<BookEntity, Long> {
    private final IBookRepository iBookRepository;

    @GetMapping
    public ResponseEntity<List<BookEntity>> findAll() {
        List<BookEntity> bookEntityList = iBookRepository.findAll();
        return ResponseEntity.ok(bookEntityList);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookEntity> findById(@PathVariable final Long bookId) {
        Optional<BookEntity> bookEntity = iBookRepository.findById(bookId);
        return bookEntity.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound()
                                                        .build());
    }

    @PutMapping
    public ResponseEntity<BookEntity> update(@Valid @RequestBody final BookEntity bookEntity) {
        return ResponseEntity.ok(iBookRepository.save(bookEntity));
    }

    @PostMapping
    public ResponseEntity<BookEntity> create(@Valid @RequestBody final BookEntity bookEntity) {
        return ResponseEntity.ok(iBookRepository.save(bookEntity));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<BookEntity> deleteById(@PathVariable final Long bookId) {
        return null;
    }
}
