package sv.edu.udb.infrastructure.persistence;

import jakarta.persistence.*;
import sv.edu.udb.core.domain.Book;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private boolean read;

    // Conversiones
    public static BookEntity fromDomain(Book book) {
        BookEntity entity = new BookEntity();
        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setRead(book.isRead());
        return entity;
    }

    public Book toDomain() {
        Book book = new Book();
        book.setId(this.id);
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setRead(this.read);
        return book;
    }

    // Getters y Setters (mismos que en Book.java)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }
}