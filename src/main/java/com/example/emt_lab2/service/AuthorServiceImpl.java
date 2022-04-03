package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Country;
import com.example.emt_lab2.model.exceptions.AuthorNotFoundException;
import com.example.emt_lab2.model.exceptions.CountryNotFoundException;
import com.example.emt_lab2.repository.JPAAuthorRepo;
import com.example.emt_lab2.repository.JPACountryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    public final JPAAuthorRepo authorRepo;
    public final JPACountryRepo countryRepo;

    public AuthorServiceImpl(JPAAuthorRepo authorRepo, JPACountryRepo countryRepo) {
        this.authorRepo = authorRepo;
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepo.findById(id).orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public List<Author> listByCountry(Long countryId) {
        Country c = countryRepo.findById(countryId).orElseThrow(CountryNotFoundException::new);
        return authorRepo.findAllByCountry(c);
    }
}
