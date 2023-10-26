package fourth_homework.book;

import fourth_homework.book.Book;
import fourth_homework.book.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(String id) {
        return bookRepository.findById(id);
    }
//    public List<Book> findAuthor(String author) {
//        return bookRepository.findByAuthor(author);
//    }

    public List<Book> findAuthor(String author) {
        List<Book> allBooks = bookRepository.findByAuthor(author);
        List<Book> result = new ArrayList<>();

        for (Book book : allBooks) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }

        return result;
    }


    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}

