package sv.edu.udb.infrastructure.web;

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

    @PostMapping
    public Book addBook(@RequestBody BookRequest request) {
        return bookService.addBook(request.getTitle(), request.getAuthor());
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}