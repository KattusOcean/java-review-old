package main.java.com.kattus.app.application.port;

public class BookDTO {
    // Class attributes
    private final String isbn;
    private final String title;
    private final String author;
    private final String genre;

    // Class constructor
    public BookDTO(String isbn, String title, String author, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    // Class getters and setters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}
