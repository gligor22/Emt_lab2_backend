package com.example.emt_lab2.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(){
        super("Author Not Found Exception");
    }
}
