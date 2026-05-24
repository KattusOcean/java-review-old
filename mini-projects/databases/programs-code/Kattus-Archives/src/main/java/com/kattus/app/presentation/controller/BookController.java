package main.java.com.kattus.app.presentation.controller;

import main.java.com.kattus.app.application.port.BookDTO;
import main.java.com.kattus.app.application.service.BookService;

public class BookController {

    private final BookService bs;

    public BookController(BookService bs) {
        this.bs = bs;
    }

    /* ===== CREATE METHOD ===== */
    /**
     * Creates a new class with the same attributes as the original Book class
     * and calls a method to create an original Book class using the copied attributes
     * @param isbn
     * @param title
     * @param author
     * @param genre
     */
    public void createBook(String isbn, String title, String author, String genre) {
        bs.addBook(new BookDTO(isbn, title, author, genre));
    }

    /* ===== DELETE METHOD ===== */
    /**
     * Creates a new class with the same attributes as the original Book class
     * and calls a method to delete the original class using the copied attributes
     * @param isbn
     * @param title
     * @param author
     * @param genre
     */
    public void deleteBook(String isbn, String title, String author, String genre) {
        bs.deleteBook(new BookDTO(isbn, title, author, genre));
    }

    /* ===== UPDATE METHODS ===== */
    public void updateBookTitle(String isbn, String newTitle, String author, String genre) {
        bs.updateBookTitle(new BookDTO(isbn, newTitle, author, genre));
    }

    public void updateBookAuthor(String isbn, String title, String newAuthor, String genre) {
        bs.updateBookAuthor(new BookDTO(isbn, title, newAuthor, genre));
    }

    public void updateBookGenre(String isbn, String title, String author, String newGenre) {
        bs.updateBookGenre(new BookDTO(isbn, title, author, newGenre));
    }

    /* ===== SHOW METHODS ===== */
    public void showBooks() {
        bs.showAllBooks();
    }

    public void showBookByIsbn(String isbn, String title, String author, String genre) {
        bs.showBookByIsbn(new BookDTO(isbn, title, author, genre));
    }

    public void showBookByTitle(String isbn, String title, String author, String genre) {
        bs.showBookByTitle(new BookDTO(isbn, title, author, genre));
    }

    public void showBookByAuthor(String isbn, String title, String author, String genre) {
        bs.showBooksByAuthor(new BookDTO(isbn, title, author, genre));
    }

    public void showBookByGenre(String isbn, String title, String author, String genre) {
        bs.showBooksByGenre(new BookDTO(isbn, title, author, genre));
    }
}
