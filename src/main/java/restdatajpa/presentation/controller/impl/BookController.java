package restdatajpa.presentation.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restdatajpa.business.facade.IBookFacade;
import restdatajpa.domain.dto.BookDto;
import restdatajpa.domain.dto.request.BookRequest;
import restdatajpa.presentation.controller.ICrudController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v2/books")
public class BookController implements ICrudController<BookDto, Long, BookRequest> {
    public final IBookFacade iBookFacade;

    @Override
    @GetMapping
    public ResponseEntity<List<BookDto>> findAll() {
        List<BookDto> bookDtoList = iBookFacade.findAll();
        return ResponseEntity.ok(bookDtoList);
    }

    @Override
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> findById(@PathVariable Long bookId) {
        BookDto bookDto = iBookFacade.findById(bookId);
        return ResponseEntity.ok(bookDto);
    }

    @Override
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteById(Long bookId) {
        iBookFacade.deleteById(bookId);
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<BookDto> create(@Valid @RequestBody BookRequest bookRequest) {
        BookDto bookDto = iBookFacade.create(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(bookDto);
    }

    @Override
    public ResponseEntity<BookDto> update(Long id, BookRequest bookRequest) {
        BookDto bookDto = iBookFacade.update(id,
                                             bookRequest);
        return ResponseEntity.ok(bookDto);
    }
}
