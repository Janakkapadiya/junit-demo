package com.junitMokito.example.junit.mokiito.service;

import com.junitMokito.example.junit.mokiito.model.Books;
import com.junitMokito.example.junit.mokiito.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    public List<Books> findAllBooks(){
        return bookRepository.findAll();
    }

    public void addBooks(int id, String name,int price){
        Books books = new Books();
        books.setId(id);
        books.setName(name);
        books.setPrice(price);
        bookRepository.save(books);
    }

    public Books replaceBook(int id, String name) {
        Optional<Books> books = bookRepository.findById(id);
        if (books.isPresent()) {
            books.get().setName(name);
            return books.get();
        }else{
            throw new BookNotFoundException();
        }
    }

    public Books getBooksById(int id) {
        Optional<Books> books = bookRepository.findById(id);
        if (books.isPresent()) {
            return books.get();
        } else {
            throw new BookNotFoundException();
        }
    }

    public Books changeBookName(Integer id, String name) {
        Optional<Books> books = bookRepository.findById(id);
        if (books.isPresent()) {
            StringBuilder changeBook = new StringBuilder();
            changeBook.replace(0, books.get().toString().length(), name);
            books.get().setName(changeBook.toString());
            return books.get();
        } else {
            throw new BookNotFoundException();
        }
    }

    public List<Books> getDiscountOnBook(int discount) {
        List<Books> books = bookRepository.findAll();

        for (Books book : books) {
            int price = book.getPrice();
            int newPrice = price - (discount * price / 100);
            book.setPrice(newPrice);
            bookRepository.save(book);
        }

        return bookRepository.findAll();
    }

    public int getTheCostOfAllTheBooks(List<Integer> id)
    {
        int total = 0;
        for(int bookId : id)
        {
            Optional<Books> book = bookRepository.findById(bookId);
            if(book.isPresent()) {
                total += book.get().getPrice();
            }
        }
        return total;
    }
}
