package com.example.emt_lab2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

    public Country( String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public Country (){}
}
