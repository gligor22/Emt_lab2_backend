package com.example.emt_lab2.web;

import com.example.emt_lab2.model.Book;
import com.example.emt_lab2.model.BookDto;
import com.example.emt_lab2.service.BookService;
import org.springframework.boot.rsocket.context.RSocketPortInfoApplicationContextInitializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookRestController {

    public final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listBooks(){
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id){
        return this.bookService.findById(id).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()-> ResponseEntity.badRequest().build());

    }

    @PostMapping("/add")
    public ResponseEntity<Book> addNewBook(@RequestBody BookDto book){
        return this.bookService.save(book).map(b -> ResponseEntity.ok().body(b))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editOldBook(@PathVariable Long id, @RequestBody BookDto book)
    {
        return this.bookService.edit(id,book).map(b -> ResponseEntity.ok().body(b))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.delete(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }


}
