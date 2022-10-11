package com.junitMokito.example.junit.mokiito.service;

import com.junitMokito.example.junit.mokiito.model.Books;
import com.junitMokito.example.junit.mokiito.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
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
