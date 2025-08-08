package sv.edu.udb.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import sv.edu.udb.core.ports.BookRepositoryPort;
import sv.edu.udb.core.domain.Book;
import sv.edu.udb.infrastructure.persistence.BookEntity;
import sv.edu.udb.infrastructure.persistence.repositories.JpaBookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookJpaAdapter implements BookRepositoryPort {
    private final JpaBookRepository jpaRepository;

    public BookJpaAdapter(JpaBookRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Book save(Book book) {
        BookEntity entity = BookEntity.fromDomain(book);
        BookEntity savedEntity = jpaRepository.save(entity);
        return savedEntity.toDomain();
    }

    @Override
    public List<Book> findAll() {
        return jpaRepository.findAll().stream()
                .map(BookEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return jpaRepository.findById(id)
                .map(BookEntity::toDomain);
    }

    @Override
    public void deleteById(Long id) {  // ¡Implementación del método faltante!
        jpaRepository.deleteById(id);
    }
}