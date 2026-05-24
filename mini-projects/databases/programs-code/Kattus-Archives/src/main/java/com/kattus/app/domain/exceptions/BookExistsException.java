package main.java.com.kattus.app.domain.exceptions;

public class BookExistsException extends RuntimeException {
    public BookExistsException (String errorMessage) {
        super(errorMessage);
    }
}
