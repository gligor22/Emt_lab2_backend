package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Book;
import com.example.emt_lab2.model.BookDto;
import com.example.emt_lab2.model.Category;
import com.example.emt_lab2.model.exceptions.AuthorNotFoundException;
import com.example.emt_lab2.model.exceptions.BookNotFoundException;
import com.example.emt_lab2.repository.JPAAuthorRepo;
import com.example.emt_lab2.repository.JPABookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    public final JPABookRepo bookRepo;

    public final JPAAuthorRepo authorRepo;

    public BookServiceImpl(JPABookRepo bookRepo, JPAAuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.of(bookRepo.findById(id).orElseThrow(BookNotFoundException::new));
    }

    @Override
    public Optional<Book> save(String name, Category category, Integer availableCopies, Long authorId) {
        if(name!=null && !name.isEmpty() && category!=null && availableCopies!=null && authorId!=null)
        {
            return Optional.of(bookRepo.save(
                    new Book(name,category,availableCopies,authorRepo.findById(authorId)
                            .orElseThrow(AuthorNotFoundException::new))));
        }
        else throw new BookNotFoundException();
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Integer availableCopies, Long authorId) {
        Book book = bookRepo.findById(id).orElseThrow(BookNotFoundException::new);
        book.setAuthor(authorRepo.findById(authorId).orElseThrow(AuthorNotFoundException::new));
        book.setCategory(category);
        book.setName(name);
        book.setAvailableCopies(availableCopies);
        return Optional.of(bookRepo.save(book));
    }

    @Override
    public Optional<Book> delete(Long id) {
        Book book = bookRepo.findById(id).orElseThrow(BookNotFoundException::new);
        bookRepo.delete(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> TakeBook(Long id) {
        Book book = bookRepo.findById(id).orElseThrow(BookNotFoundException::new);
        if(book.getAvailableCopies()>0)
            book.setAvailableCopies(book.getAvailableCopies()-1);
        else throw new BookNotFoundException();
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto book) {
        Book b = new Book(book.getName(),book.getCategory(),book.getAvailableCopies(),book.getAuthor());
       return Optional.of(b);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto b) {
        Book book = bookRepo.findById(id).orElseThrow(BookNotFoundException::new);
        book.setAuthor(b.getAuthor());
        book.setCategory(b.getCategory());
        book.setName(b.getName());
        book.setAvailableCopies(b.getAvailableCopies());
        return Optional.of(bookRepo.save(book));
    }
}
