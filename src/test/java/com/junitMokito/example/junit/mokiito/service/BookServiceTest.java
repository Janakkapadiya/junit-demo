package com.junitMokito.example.junit.mokiito.service;

import com.junitMokito.example.junit.mokiito.model.Books;
import com.junitMokito.example.junit.mokiito.repo.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setup() {
        this.bookService = new BookService(this.bookRepository);
    }

    @Test
    void findAllBooks() {
        bookService.findAllBooks();
        verify(bookRepository).findAll();
    }


    @Test
    void addBooks() {
        Books books = new Books(1, "ravan");
        bookService.addBooks(1, "ravan");
        verify(bookRepository).save(books);
    }

    @Test
    void getBooksById() {
        Books books = new Books(1, "raven");
        bookService.getBooksById(1);
        verify(bookRepository).findById(books.getId());
    }

    @Test
    void replaceBook() {
        Books books = new Books(1, "raven");
        bookService.replaceBook(1, "war of lanka");
        if (bookRepository.checkIfUserExistById(1)) {
            Assertions.assertNotEquals(books.getName(), bookService.getBooksById(1).get().getName());
        }
    }
}