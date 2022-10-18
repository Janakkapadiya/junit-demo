package com.junitMokito.example.junit.mokiito.controller;

import com.junitMokito.example.junit.mokiito.dto.BookDto;
import com.junitMokito.example.junit.mokiito.model.Books;
import com.junitMokito.example.junit.mokiito.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @PutMapping("/changeBookName/{id}")
    public void updateBookName(@PathVariable("id") int id, @RequestBody BookDto user) {
        bookService.replaceBook(id, user.getName());
    }

    @GetMapping("/findAll")
    public Collection<Books> findAll() {
        return bookService.findAllBooks();
    }

    @PostMapping("/addBooks")
    public Books addBooks(@RequestBody BookDto book)
    {
        return bookService.addBooks(book.getId(), book.getName(),book.getPrice());
    }

    @PostMapping("/changeBookName/{id}")
    public void changeBookName(@RequestBody BookDto user, @PathVariable int id)  {
        bookService.changeBookName(id, user.getName());
    }
}
