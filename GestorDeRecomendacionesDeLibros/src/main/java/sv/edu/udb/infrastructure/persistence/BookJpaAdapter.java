package sv.edu.udb.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.udb.core.ports.BookRepositoryPort;
import sv.edu.udb.core.domain.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookJpaAdapter implements BookRepositoryPort {
    private final JpaRepository<BookEntity, Long> jpaRepository;

    public BookJpaAdapter(JpaRepository<BookEntity, Long> jpaRepository) {
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
}