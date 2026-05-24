package main.java.com.kattus.app.domain.validations;

import main.java.com.kattus.app.application.port.BookDTO;
import main.java.com.kattus.app.domain.entities.Book;

public class BookValidation {

    /**
     * Validates if the primary key (isbn) is null or was not introduced
     * @param bdto
     * @return
     */
    public boolean isBookValid (BookDTO bdto) {
        if (bdto.getIsbn() == null || bdto.getIsbn().isBlank()) {
            throw new IllegalArgumentException("ISBN required");
        }
        return true;
    }
}
