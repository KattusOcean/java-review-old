package main.java.com.kamazon.domain.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidCredentialsException(String message) { super(message); }
    public InvalidCredentialsException() {}
}
