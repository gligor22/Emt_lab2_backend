package com.example.emt_lab2;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Category;
import com.example.emt_lab2.model.Country;
import com.example.emt_lab2.repository.JPAAuthorRepo;
import com.example.emt_lab2.repository.JPACountryRepo;
import com.example.emt_lab2.service.BookService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitilizer {

    public final JPAAuthorRepo authorService;
    public final JPACountryRepo countryRepo;
    public final BookService bookService;

    public DataInitilizer(JPAAuthorRepo authorService, JPACountryRepo countryRepo, BookService bookService) {
        this.authorService = authorService;
        this.countryRepo = countryRepo;
        this.bookService = bookService;
    }

    @PostConstruct
    public void Fill()
    {
        Country c = new Country("MKD","Europe");
        countryRepo.save(c);
        authorService.save(new Author("Gligor","Petkov",c));
        bookService.save("Titanic", Category.DRAMA,5,authorService.findAll().stream().findFirst().get().getId());
    }
}
