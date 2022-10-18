package com.junitMokito.example.junit.mokiito.service;

import com.junitMokito.example.junit.mokiito.model.Books;
import com.junitMokito.example.junit.mokiito.repo.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.BDDMockito.*;
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
        Books books = new Books(7,"abc",100);
        bookService.addBooks(7,"abc",100);
        Assertions.assertEquals(7,books.getId());
    }

    @Test
    void getBooksById() {
        Books books = new Books();
        books.setId(1);
        books.setName("abc");
        books.setPrice(200);
        Optional<Books> findBooks = Optional.of(books);
        when(bookRepository.findById(1)).thenReturn(findBooks);
        Books books1 = bookService.getBooksById(1);
        Assertions.assertEquals(1,books1.getId());
    }

    @Test
    void replaceBook() {
        Books books = new Books();
        books.setId(1);
        books.setName("abc");
        Optional<Books> book = Optional.of(books);
        when(bookRepository.findById(1)).thenReturn(book);
        Books changeBook = bookService.replaceBook(1,"ravan");
        Assertions.assertNotEquals("abc",changeBook.getName());
    }


    @Test
    void changeBookName(){
        Books books = new Books();
        books.setId(1);
        books.setName("abc");
        Optional<Books> book1 = Optional.of(books);
        when(bookRepository.findById(1)).thenReturn(book1);
        Books books1 = bookService.changeBookName(1,"cde");
        Assertions.assertNotEquals("abc",books1.getName());
    }

    @Test
    void testExpectedException() {
        Books book = new Books();
        book.setId(1);
        book.setName("abc");
        Optional<Books> optionalBooks = Optional.of(book);
        given(bookRepository.findById(1)).willReturn(optionalBooks);
        Books foundBook = bookService.getBooksById(1);
        Assertions.assertEquals(1,foundBook.getId());
        Assertions.assertEquals("abc",foundBook.getName());
    }

    @Test
    void getDiscountOnBook() {
        List<Books> newBooks = new ArrayList<>();
        newBooks.add(new Books(5,"cp",100));
        newBooks.add(new Books(9,"dsa",300));
        when(bookRepository.findAll()).thenReturn(newBooks);
        List<Books> allBooks = bookService.getDiscountOnBook(10);
        Assertions.assertEquals(2,allBooks.size());
        Assertions.assertEquals(90,allBooks.get(0).getPrice());
    }


}