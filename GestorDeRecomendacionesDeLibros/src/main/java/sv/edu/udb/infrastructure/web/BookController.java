package sv.edu.udb.infrastructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.core.domain.Book;
import sv.edu.udb.core.service.BookService;
import sv.edu.udb.infrastructure.web.dto.BookRequest;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Crear libro
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookRequest request) {
        Book book = bookService.addBook(request.getTitle(), request.getAuthor());
        return ResponseEntity.status(201).body(book);
    }

    // Obtener todos los libros
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Obtener libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar libro
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long id,
            @RequestBody BookRequest request
    ) {
        return bookService.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(request.getTitle());
                    existingBook.setAuthor(request.getAuthor());
                    Book updatedBook = bookService.save(existingBook);
                    return ResponseEntity.ok(updatedBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Marcar como leído
    @PatchMapping("/{id}/mark-as-read")
    public ResponseEntity<Book> markAsRead(@PathVariable Long id) {
        return bookService.findById(id)
                .map(book -> {
                    book.setRead(true);
                    Book updatedBook = bookService.save(book);
                    return ResponseEntity.ok(updatedBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint de prueba
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API funcionando correctamente");
    }
}