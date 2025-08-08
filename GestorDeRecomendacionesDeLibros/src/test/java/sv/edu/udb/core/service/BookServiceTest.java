package sv.edu.udb.core.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sv.edu.udb.core.domain.Book;
import sv.edu.udb.core.ports.BookRepositoryPort;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepositoryPort repository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testAddBook() {
        // Configura el mock
        Book book = new Book("El Hobbit", "J.R.R. Tolkien", false);
        when(repository.save(any(Book.class))).thenReturn(book);

        // Ejecuta el método
        Book result = bookService.addBook("El Hobbit", "J.R.R. Tolkien");

        // Verifica
        assertEquals("El Hobbit", result.getTitle());
        verify(repository, times(1)).save(any(Book.class));
    }

    @Test
    void testGetAllBooks() {
        // Configura el mock
        Book book = new Book("1984", "George Orwell", true);
        when(repository.findAll()).thenReturn(List.of(book));

        // Ejecuta el método
        List<Book> books = bookService.getAllBooks();

        // Verifica
        assertEquals(1, books.size());
        assertEquals("1984", books.get(0).getTitle());
    }
}