package main.java.com.kattus.app.domain.entities;

public class Book {

    // Class attributes
    private String isbn;
    private String title;
    private String author = "Unknown";
    private String genre = "Unknown";

    // Class constructor
    public Book(String isbn, String title, String author, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    // Class getters and setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Class toString
    @Override
    public String toString() {
        return "ISBN = " + isbn + " | Title = " + title +  " | Author = " + author + " | Genre = " + genre;
    }
}
