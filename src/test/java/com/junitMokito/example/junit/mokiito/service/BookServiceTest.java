package com.junitMokito.example.junit.mokiito.service;
import com.junitMokito.example.junit.mokiito.model.Books;
import com.junitMokito.example.junit.mokiito.repo.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.BDDMockito.*;
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @Test
    void findAllBooks(){
        List<Books> books = new ArrayList<>();
        books.add(new Books(1,"ravan",500));
        books.add(new Books(2,"ram",1000));
        when(bookRepository.findAll()).thenReturn(books);
        List<Books> book = bookService.findAllBooks();
        Assertions.assertEquals(2,book.size());
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
        Assertions.assertEquals(1, books1.getId());
    }

    @Test
    void replaceBook() {
        Books books = new Books();
        books.setId(1);
        books.setName("abc");
        Optional<Books> book = Optional.of(books);
        when(bookRepository.findById(1)).thenReturn(book);
        Books changeBook = bookService.replaceBook(1, "ravan");
        Assertions.assertNotEquals("abc", changeBook.getName());
    }


    @Test
    void changeBookName() {
        Books books = new Books();
        books.setId(1);
        books.setName("abc");
        Optional<Books> book1 = Optional.of(books);
        when(bookRepository.findById(1)).thenReturn(book1);
        Books books1 = bookService.changeBookName(1, "cde");
        Assertions.assertNotEquals("abc", books1.getName());
    }

    @Test
    void testExpectedException() {
        Books book = new Books();
        book.setId(1);
        book.setName("abc");
        Optional<Books> optionalBooks = Optional.of(book);
        given(bookRepository.findById(1)).willReturn(optionalBooks);
        Books foundBook = bookService.getBooksById(1);
        Assertions.assertEquals(1, foundBook.getId());
        Assertions.assertEquals("abc", foundBook.getName());
    }

    @Test
    void getDiscountOnBook() {
        List<Books> newBooks = new ArrayList<>();
        newBooks.add(new Books(5, "cp", 100));
        newBooks.add(new Books(9, "dsa", 300));
        when(bookRepository.findAll()).thenReturn(newBooks);
        List<Books> allBooks = bookService.getDiscountOnBook(10);
        Assertions.assertEquals(2, allBooks.size());
        Assertions.assertEquals(90, allBooks.get(0).getPrice());
    }


    @Test
    void getTheCostOfAllTheBooks() {
       List<Integer> bookId = new ArrayList<>();
       bookId.add(12);
       bookId.add(13);

       Books book1 = new Books(12,"nothing",300);
       Books book2 = new Books(13,"nothing2",400);

       when(bookRepository.findById(12)).thenReturn(Optional.of(book1));
       when(bookRepository.findById(13)).thenReturn(Optional.of(book2));

       int cost = bookService.getTheCostOfAllTheBooks(bookId);

       Assertions.assertEquals(700,cost);

    }
    @Test
    void TestAddBook()
    {
        Books books = new Books(7,"abc",100);
        bookService.addBooks(7,"abc",100);
        verify(bookRepository,times(1)).save(books);
    }


    //v - 32
}