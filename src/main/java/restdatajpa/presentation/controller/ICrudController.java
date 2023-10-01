package restdatajpa.presentation.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICrudController<T, N> {
    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> findById(N id);

    ResponseEntity<T> update(T item);

    ResponseEntity<T> create(T item);

    ResponseEntity<T> deleteById(N id);
}
