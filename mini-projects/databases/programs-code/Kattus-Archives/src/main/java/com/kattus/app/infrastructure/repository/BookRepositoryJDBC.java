package main.java.com.kattus.app.infrastructure.repository;

import main.java.com.kattus.app.infrastructure.db.DbConnection;

import java.sql.*;

public class BookRepositoryJDBC implements BookRepository {

    /* ===== INSERT METHODS ===== */
    /**
     * Inserts the book in the database
     * @param isbn
     * @param title
     * @param author
     * @param genre
     */
    public void insertBook(String isbn, String title, String author, String genre) {
        String sql = "INSERT INTO archives_space.book VALUES (UPPER(?), UPPER(?), UPPER(?), UPPER(?))";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, isbn);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, genre);

            try {
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new SQLIntegrityConstraintViolationException();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    /* ===== UPDATE METHODS ===== */
    /**
     * Updates book title in the database
     * @param newTitle
     * @param isbn
     */
    public void updateBookTitle(String newTitle, String isbn) {
        String sql = "UPDATE archives_space.book SET title = UPPER(?) WHERE isbn = UPPER(?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newTitle);
            ps.setString(2, isbn);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    /**
     * Updates book author in the database
     * @param newAuthor
     * @param isbn
     */
    public void updateBookAuthor(String newAuthor, String isbn) {
        String sql = "UPDATE archives_space.book SET author = UPPER(?) WHERE isbn = UPPER(?) ";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newAuthor);
            ps.setString(2, isbn);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    /**
     * Updates book genre in the database
     * @param newGenre
     * @param isbn
     */
    public void updateBookGenre(String newGenre, String isbn) {
        String sql = "UPDATE archives_space.book SET genre = UPPER(?) WHERE isbn = UPPER(?) ";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newGenre);
            ps.setString(2, isbn);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    /* ===== DELETE METHODS ===== */
    /**
     * Deletes the book in the database
     * @param isbn
     */
    public void deleteBook(String isbn) {
        String sql = "DELETE FROM archives_space.book WHERE isbn = UPPER(?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, isbn);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    /* ===== SEARCH METHODS ===== */
    public void searchAllBooks() {
        String sql = "SELECT * FROM archives_space.book ORDER BY isbn";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String rsIsbn = rs.getString(1);
                String rsTitle = rs.getString(2);
                String rsAuthor = rs.getString(3);
                String rsGenre = rs.getString(4);
                System.out.println(rsIsbn + " | " + rsTitle + " | " + rsAuthor + " | " + rsGenre);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Searches a book in the database by its isbn
     * @param isbn
     */
    public void searchBookByIsbn(String isbn) {
        String sql = "SELECT * FROM archives_space.book WHERE isbn = UPPER(?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, isbn);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String rsIsbn = rs.getString(1);
                    String rsTitle = rs.getString(2);
                    String rsAuthor = rs.getString(3);
                    String rsGenre = rs.getString(4);
                    System.out.println(rsIsbn + " | " + rsTitle + " | " + rsAuthor + " | " + rsGenre);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    /**
     * Searches the books in the database named like the given title
     * @param title
     */
    public void searchBookByTitle(String title) {
        String sql = "SELECT * FROM archives_space.book WHERE title = UPPER(?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, title);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String rsIsbn = rs.getString(1);
                    String rsTitle = rs.getString(2);
                    String rsAuthor = rs.getString(3);
                    String rsGenre = rs.getString(4);
                    System.out.println(rsIsbn + " | " + rsTitle + " | " + rsAuthor + " | " + rsGenre);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    /**
     * Searches the books in the database named like the given author
     * @param author
     */
    public void searchBookByAuthor(String author) {
        String sql = "SELECT * FROM archives_space.book WHERE author = UPPER(?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, author);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String rsIsbn = rs.getString(1);
                    String rsTitle = rs.getString(2);
                    String rsAuthor = rs.getString(3);
                    String rsGenre = rs.getString(4);
                    System.out.println(rsIsbn + " | " + rsTitle + " | " + rsAuthor + " | " + rsGenre);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    /**
     * Searches the books in the database named like the given genre
     * @param genre
     */
    public void searchBookByGenre(String genre) {
        String sql = "SELECT * FROM archives_space.book WHERE genre = UPPER(?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, genre);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String rsIsbn = rs.getString(1);
                    String rsTitle = rs.getString(2);
                    String rsAuthor = rs.getString(3);
                    String rsGenre = rs.getString(4);
                    System.out.println(rsIsbn + " | " + rsTitle + " | " + rsAuthor + " | " + rsGenre);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    /* ===== CHECK METHODS ===== */

    /**
     * Checks if the book exists in the database by the isbn
     * @param isbn
     * @return
     */
    public boolean bookExistsByIsbn(String isbn) {
        String sql = "SELECT COUNT(*) FROM archives_space.book WHERE isbn = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, isbn);

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                int rsCount = rs.getInt(1);

                if (rsCount >= 1) { return true; }
                else { return false; }
            }

        } catch (SQLException e) {
            return true;
        }
    }
}
