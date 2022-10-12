package com.junitMokito.example.junit.mokiito.service;

import com.junitMokito.example.junit.mokiito.dto.UserDto;
import com.junitMokito.example.junit.mokiito.model.Books;
import com.junitMokito.example.junit.mokiito.repo.BookRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    @Autowired
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
        Books books = new Books(4,"janak");
        // when
        bookService.addBooks(4,"janak");

        //then
        ArgumentCaptor<Books> argumentCaptor = ArgumentCaptor.forClass(Books.class);
        verify(bookRepository).save(argumentCaptor.capture());

        Books book = argumentCaptor.getValue();
        Assertions.assertEquals(book,books);


          //upper method or below method

//        Books books = new Books(4,"janak");
//        bookService.addBooks(4,"janak");
//        verify(bookRepository).save(books);
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