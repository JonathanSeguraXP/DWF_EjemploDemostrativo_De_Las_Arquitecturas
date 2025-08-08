package sv.edu.udb.core.domain;

public class Book {
    private Long id;
    private String title;
    private String author;
    private boolean read;

    // Constructores
    public Book() {}
    public Book(String title, String author, boolean read) {
        this.title = title;
        this.author = author;
        this.read = read;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }
}