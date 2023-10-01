package restdatajpa.presentation.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICrudController<T, N> {
    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> findById(N id);

    ResponseEntity<T> create(T item);

    ResponseEntity<Void> update(T item);

    ResponseEntity<Void> deleteById(N id);
}
