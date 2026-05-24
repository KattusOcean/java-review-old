package main.java.com.kamazon.domain.exceptions;

public class AccessNotValidException extends RuntimeException {
    public AccessNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
