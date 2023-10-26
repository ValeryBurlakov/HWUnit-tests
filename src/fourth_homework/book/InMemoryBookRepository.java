package fourth_homework.book;

import fourth_homework.book.Book;
import fourth_homework.book.BookRepository;

import java.util.*;

public class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> books;

    public InMemoryBookRepository() {
        this.books = new HashMap<>();
//        books.put("1", new Book("1", "Book1", "Author1"));
//        books.put("2", new Book("2", "Book2", "Author2"));
//        books.put("3", new Book("3", "Book3", "Author5"));
    }

    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }


    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

}
