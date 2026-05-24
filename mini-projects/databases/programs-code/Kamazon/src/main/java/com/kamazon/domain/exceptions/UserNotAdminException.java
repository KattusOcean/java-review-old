package main.java.com.kamazon.domain.exceptions;

public class UserNotAdminException extends RuntimeException {
    public UserNotAdminException(String message, Throwable cause) {
        super(message, cause);
    }
}
