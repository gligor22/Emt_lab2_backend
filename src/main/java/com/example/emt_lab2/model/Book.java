package com.example.emt_lab2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    private Integer availableCopies;

    @ManyToOne
    private Author author;

    public Book(String name, Category category, Integer availableCopies, Author author) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }

    public Book() {
    }
}
