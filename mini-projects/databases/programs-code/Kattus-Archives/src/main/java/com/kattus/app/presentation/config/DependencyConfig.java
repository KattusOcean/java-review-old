package main.java.com.kattus.app.presentation.config;

import main.java.com.kattus.app.application.service.BookService;
import main.java.com.kattus.app.domain.validations.BookValidation;
import main.java.com.kattus.app.infrastructure.repository.BookRepository;
import main.java.com.kattus.app.infrastructure.repository.BookRepositoryJDBC;
import main.java.com.kattus.app.presentation.controller.BookController;
import main.java.com.kattus.app.presentation.view.BookConsoleView;

public class DependencyConfig {
    /**
     * Creates a new BookService with BookRepository SQL queries and validation methods
     * @return
     */
    public BookService bs () {
        BookRepository br = new BookRepositoryJDBC();
        BookValidation bv = new BookValidation();
        BookConsoleView bcv = new BookConsoleView();
        return new BookService(br, bv, bcv);
    }

    /**
     * Creates a new BookController with a full operational BookService created before
     * @return
     */
    public BookController bc() {
        BookService bs = bs();
        return new BookController(bs);
    }
}
