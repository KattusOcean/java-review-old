package main.java.com.kamazon.domain.exceptions;

public class ProductNotValidException extends RuntimeException {
    public ProductNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
