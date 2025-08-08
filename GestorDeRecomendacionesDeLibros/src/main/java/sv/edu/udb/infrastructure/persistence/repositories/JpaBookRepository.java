package sv.edu.udb.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.infrastructure.persistence.BookEntity;

public interface JpaBookRepository extends JpaRepository<BookEntity, Long> {

}