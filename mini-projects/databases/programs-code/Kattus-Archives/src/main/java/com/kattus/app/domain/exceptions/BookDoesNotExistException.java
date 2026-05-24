package main.java.com.kattus.app.domain.exceptions;

public class BookDoesNotExistException extends RuntimeException {
    public BookDoesNotExistException(String message) {
        super(message);
    }
}
