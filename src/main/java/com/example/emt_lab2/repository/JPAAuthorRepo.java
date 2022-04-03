package com.example.emt_lab2.repository;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAAuthorRepo extends JpaRepository<Author,Long> {
    List<Author> findAllByCountry(Country c);
}
