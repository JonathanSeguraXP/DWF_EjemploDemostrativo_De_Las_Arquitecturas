package sv.edu.udb.core.ports;

import sv.edu.udb.core.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepositoryPort {
    Book save(Book book);
    List<Book> findAll();
    Optional<Book> findById(Long id);
}