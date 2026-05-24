package main.java.com.kattus.app.application.service;

import main.java.com.kattus.app.application.port.BookDTO;
import main.java.com.kattus.app.domain.exceptions.BookDoesNotExistException;
import main.java.com.kattus.app.domain.exceptions.BookExistsException;
import main.java.com.kattus.app.domain.validations.BookValidation;
import main.java.com.kattus.app.infrastructure.repository.BookRepository;
import main.java.com.kattus.app.presentation.view.BookConsoleView;

public class BookService {

    private final BookRepository repository;
    private final BookValidation validation;
    private final BookConsoleView consoleView;

    /**
     * Class constructor
     * @param repository
     * @param validation
     */
    public BookService(BookRepository repository, BookValidation validation, BookConsoleView consoleView) {
        this.repository = repository;
        this.validation = validation;
        this.consoleView = consoleView;
    }

    /* ===== ADD METHOD ===== */
    /**
     * Search and validate the given book attributes
     * Once found and validated, passes the given book attributes to the insertion SQL queries
     * @param bdto
     */
    public void addBook(BookDTO bdto) {

        if (repository.bookExistsByIsbn(bdto.getIsbn())) {
            throw new BookExistsException("Book already exist!");
        }

        if (!validation.isBookValid(bdto)) {
            throw new IllegalArgumentException("ISBN required!");
        }

        repository.insertBook(bdto.getIsbn(), bdto.getTitle(), bdto.getAuthor(), bdto.getGenre());
        consoleView.bookInsertedCorrectly();
    }

    /* ===== DELETE METHOD ===== */
    /**
     * Search and validate the given book attributes
     * Once found and validated, passes the given book attributes to the deletion SQL queries
     * @param bdto
     */
    public void deleteBook(BookDTO bdto) {
        if (!repository.bookExistsByIsbn(bdto.getIsbn())) {
            throw new BookDoesNotExistException("Book does not exist!");
        }

        if (!validation.isBookValid(bdto)) {
            throw new IllegalArgumentException("ISBN required!");
        }

        repository.deleteBook(bdto.getIsbn());
        consoleView.bookDeletedCorrectly();
    }

    /* ===== UPDATE METHODS ===== */
    /**
     * Search and validate the given book attributes
     * Once found and validated, passes the given book attributes to the title update SQL queries
     * @param bdto
     */
    public void updateBookTitle(BookDTO bdto) {
        if (!repository.bookExistsByIsbn(bdto.getIsbn())) {
            throw new BookDoesNotExistException("Book does not exist!");
        }

        if (!validation.isBookValid(bdto)) {
            throw new IllegalArgumentException("ISBN required!");
        }

        repository.updateBookTitle(bdto.getTitle(), bdto.getIsbn());
        consoleView.bookTitleUpdatedCorrectly();
    }

    /**
     * Search and validate the given book attributes
     * Once found and validated, passes the given book attributes to the author update SQL queries
     * @param bdto
     */
    public void updateBookAuthor(BookDTO bdto) {
        if (!repository.bookExistsByIsbn(bdto.getIsbn())) {
            throw new BookDoesNotExistException("Book does not exist!");
        }

        if (!validation.isBookValid(bdto)) {
            throw new IllegalArgumentException("ISBN required!");
        }

        repository.updateBookAuthor(bdto.getAuthor(), bdto.getIsbn());
        consoleView.bookAuthorUpdatedCorrectly();
    }

    /**
     * Search and validate the given book attributes
     * Once found and validated, passes the given book attributes to the genre update SQL queries
     * @param bdto
     */
    public void updateBookGenre(BookDTO bdto) {
        if (!repository.bookExistsByIsbn(bdto.getIsbn())) {
            throw new BookDoesNotExistException("Book does not exist!");
        }

        if (!validation.isBookValid(bdto)) {
            throw new IllegalArgumentException("ISBN required!");
        }

        repository.updateBookGenre(bdto.getGenre(), bdto.getIsbn());
        consoleView.bookGenreUpdatedCorrectly();
    }

    public void showAllBooks() {
        repository.searchAllBooks();
    }

    public void showBookByIsbn(BookDTO bdto) {
        repository.searchBookByIsbn(bdto.getIsbn());
    }

    public void showBookByTitle(BookDTO bdto) {
        repository.searchBookByTitle(bdto.getTitle());
    }

    public void showBooksByAuthor(BookDTO bdto) {
        repository.searchBookByAuthor(bdto.getAuthor());
    }

    public void showBooksByGenre(BookDTO bdto) {
        repository.searchBookByGenre(bdto.getGenre());
    }
}
