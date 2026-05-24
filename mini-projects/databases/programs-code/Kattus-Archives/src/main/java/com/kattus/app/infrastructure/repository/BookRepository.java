package main.java.com.kattus.app.infrastructure.repository;

public interface BookRepository {

    /** ===== INSERT METHODS ===== */
    void insertBook(String isbn, String title, String author, String genre);

    /** ===== UPDATE METHODS ===== */
    void updateBookTitle(String newTitle, String isbn);
    void updateBookAuthor(String newAuthor, String isbn);
    void updateBookGenre(String newGenre, String isbn);

    /** ===== DELETE METHODS ===== */
    void deleteBook(String isbn);

    /* ===== SEARCH METHODS ===== */
    void searchAllBooks();
    void searchBookByIsbn(String isbn);
    void searchBookByTitle(String title);
    void searchBookByAuthor(String author);
    void searchBookByGenre(String genre);

    /* ===== CHECK METHODS ===== */
    boolean bookExistsByIsbn(String isbn);
}
