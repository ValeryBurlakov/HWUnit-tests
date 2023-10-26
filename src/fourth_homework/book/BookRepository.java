package fourth_homework.book;

import fourth_homework.book.Book;

import java.util.List;

public interface BookRepository {
    Book findById(String id);
    List<Book> findAll();
    List<Book> findByAuthor(String author);

}
