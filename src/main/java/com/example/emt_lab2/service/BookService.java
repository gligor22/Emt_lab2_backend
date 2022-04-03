package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Book;
import com.example.emt_lab2.model.BookDto;
import com.example.emt_lab2.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, Category category, Integer availableCopies, Long authorId);

    Optional<Book> edit(Long id, String name, Category category, Integer availableCopies, Long authorId);

    Optional<Book> delete(Long id);

    Optional<Book> TakeBook(Long id);

    Optional<Book> save(BookDto book);

    Optional<Book> edit(Long id, BookDto b);
}
