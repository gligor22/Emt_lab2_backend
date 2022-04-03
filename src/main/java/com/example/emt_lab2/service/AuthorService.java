package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author findById(Long id);

    List<Author> listByCountry(Long countryId);
}
