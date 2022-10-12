package com.junitMokito.example.junit.mokiito.controller;

import com.junitMokito.example.junit.mokiito.dto.UserDto;
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
    public void updateBookName(@PathVariable("id") int id, @RequestBody UserDto user) {
        bookService.replaceBook(id, user.getName());
    }

    @GetMapping("/findAll")
    public Collection<Books> findAll() {
        return bookService.findAllBooks();
    }

    @PostMapping("/addBooks")
    public Books addBooks(@RequestBody UserDto user)
    {
        return bookService.addBooks(user.getId(), user.getName());
    }
}
