package com.junitMokito.example.junit.mokiito.repo;

import com.junitMokito.example.junit.mokiito.model.Books;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    void checkIfUserExistById() {
        Books books = new Books(1, "ravan");
        repository.save(books);
        Assertions.assertTrue(repository.checkIfUserExistById(1));
    }
}