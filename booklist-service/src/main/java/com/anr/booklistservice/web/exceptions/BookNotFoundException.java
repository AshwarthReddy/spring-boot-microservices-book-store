package com.anr.booklistservice.web.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }

    public static BookNotFoundException forCode(String code) {
        return new BookNotFoundException("Product with code " + code + " not found");
    }
}
