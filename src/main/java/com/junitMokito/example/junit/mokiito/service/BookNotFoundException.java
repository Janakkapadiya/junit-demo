package com.junitMokito.example.junit.mokiito.service;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book Not Found!!");
    }
}
