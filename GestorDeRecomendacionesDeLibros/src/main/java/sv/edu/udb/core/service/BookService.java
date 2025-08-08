package sv.edu.udb.core.service;

import org.springframework.stereotype.Service;
import sv.edu.udb.core.domain.Book;
import sv.edu.udb.core.ports.BookRepositoryPort;
import java.util.List;

@Service
public class BookService {
    private final BookRepositoryPort repository;

    public BookService(BookRepositoryPort repository) {
        this.repository = repository;
    }

    public Book addBook(String title, String author) {
        Book book = new Book(title, author, false);
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }
}