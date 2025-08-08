package sv.edu.udb.infrastructure.web.dto;

public class BookRequest {
    private String title;
    private String author;

    // Getters y setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}