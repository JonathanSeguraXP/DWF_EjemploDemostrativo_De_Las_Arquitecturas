package sv.edu.udb.core.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sv.edu.udb.core.domain.Book;
import sv.edu.udb.core.ports.BookRepositoryPort;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    public Book save(Book book) {  // <- Nuevo método
        return repository.save(book);
    }

    public void deleteById(Long id) {  // <- Nuevo método
        repository.deleteById(id);
    }
}