package com.example.emt_lab2.repository;

import com.example.emt_lab2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPABookRepo extends JpaRepository<Book,Long> {
}
