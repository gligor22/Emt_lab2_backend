package com.example.emt_lab2.model.exceptions;

public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException(){
        super("Country Not Found Exception");
    }
}
