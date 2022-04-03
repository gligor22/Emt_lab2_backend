package com.example.emt_lab2.model.exceptions;

import com.example.emt_lab2.model.Book;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException()
    {
        super("Book Not Found Exception");
    }

}
