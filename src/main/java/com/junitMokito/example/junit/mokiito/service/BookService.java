package com.junitMokito.example.junit.mokiito.service;

import com.junitMokito.example.junit.mokiito.model.Books;
import com.junitMokito.example.junit.mokiito.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;


    public Collection<Books> findAllBooks() {
        return bookRepository.findAll();
    }

    public void addBooks(int id, String name) {
        Books books = new Books();
        books.setId(id);
        books.setName(name);
        bookRepository.save(books);
    }

    public void replaceBook(int id, String name) {
        Optional<Books> books = bookRepository.findById(id);
        if (books.isPresent()) {
            books.get().setName(name);
            bookRepository.save(books.get());
        }
    }
    
    public void findAllBooks()
    {
        bookRepository.findAll();
    }

    public Books addBooks(int id, String name)
    {
        Books books = new Books();
        books.setId(id);
        books.setName(name);
        return bookRepository.save(books);
    }

    public Optional<Books> getBooksById(int id)
    {
        return bookRepository.findById(id);
    }
}
