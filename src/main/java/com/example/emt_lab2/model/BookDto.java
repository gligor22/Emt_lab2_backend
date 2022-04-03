package com.example.emt_lab2.model;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
public class BookDto
{
    private String name;

    private Category category;

    private Integer availableCopies;

    private Author author;

    public BookDto(String name, Category category, Integer availableCopies, Author author) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }
}
