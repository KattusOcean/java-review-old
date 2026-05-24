package main.java.com.kattus.app;

import main.java.com.kattus.app.presentation.config.DependencyConfig;
import main.java.com.kattus.app.presentation.controller.BookController;

public class Main {
    static void main() {
        // Calls DependencyConfig file
        DependencyConfig dc = new DependencyConfig();

        // Creates a new BookController using the DependencyConfig constructor (that includes BookService)
        BookController bc = dc.bc();
        System.out.println("----- EVERY BOOK 1 -----");
        bc.showBooks();

        System.out.println();

        System.out.println("--------------------------------------------");
        System.out.println("----- BOOK(S) BY GENRE 'MUSIC' -----");
        bc.showBookByGenre("", "", "", "music");
        System.out.println("--------------------------------------------");
        System.out.println("----- BOOK(S) BY AUTHOR 'GOD' -----");
        bc.showBookByAuthor("-", "nothing", "god", "nothing2");
        System.out.println("--------------------------------------------");

        System.out.println();

        System.out.println("----- CREATE BOOK -----");
        bc.createBook("4040404040404", "Atomic habits", "james Clear", "self help");
        System.out.println("--------------------------------------------");
        System.out.println("----- EVERY BOOK 2 -----");
        bc.showBooks();

        System.out.println();

        System.out.println("----- UPDATE BOOK GENRE -----");
        bc.updateBookTitle("4040404040404", "SubAtomic habits", "james Clear", "self help");
        bc.updateBookAuthor("4040404040404", "Atomic habits", "Clear james", "self help");
        bc.updateBookGenre("4040404040404", "Atomic habits", "james Clear", "Geography");
        System.out.println("--------------------------------------------");
        System.out.println("----- EVERY BOOK 3 -----");
        bc.showBooks();

        System.out.println();

        System.out.println("----- DELETE BOOK -----");
        bc.deleteBook("4040404040404", "Atomic Habits", "James Clear", "Self help");
        System.out.println("--------------------------------------------");
        System.out.println("----- EVERY BOOK 4 -----");
        bc.showBooks();
    }
}
