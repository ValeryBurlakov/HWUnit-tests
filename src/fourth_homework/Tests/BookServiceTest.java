package fourth_homework.Tests;

import fourth_homework.book.Book;
import fourth_homework.book.BookRepository;
import fourth_homework.book.BookService;
import fourth_homework.book.InMemoryBookRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class BookServiceTest {
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookRepository = mock(InMemoryBookRepository.class);
        bookService = new BookService(bookRepository);
    }
    @Test
    public void testNumberBooksOneAuthor() {
        Book book1 = new Book("1", "book3", "author3");
        Book book2 = new Book("2", "book2", "author2");
        Book book3 = new Book("3", "book5", "author2");
        Book book4 = new Book("4", "book4", "author5");
        String author = "author2";
        List<Book> books = new ArrayList<>(List.of(book1, book2, book3, book4));

        when(bookRepository.findByAuthor(author)).thenReturn(books);
        List<Book> listOfBooks = bookService.findAuthor(author);
        assertEquals(2, listOfBooks.size());
    }

    @Test
    public void testFindBookById() {
        Book book = new Book("1", "book4", "author2");
        when(bookRepository.findById("1")).thenReturn(book);
        Book testBook = bookService.findBookById("1");
        assertEquals(book, testBook);
        System.out.println(testBook);
        verify(bookRepository, times(1)).findById("1");
    }

    @Test
    public void testFindAllBook() {
        Book book1 = new Book("1", "book3", "author3");
        Book book2 = new Book("2", "book2", "author2");
        List<Book> books = new ArrayList<>(List.of(book1, book2));
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> listOfBooks = bookService.findAllBooks();
        assertEquals(books, listOfBooks);
        verify(bookRepository, times(1)).findAll();
    }
}