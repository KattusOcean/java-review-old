package main.java.com.kamazon.presentation.view;

import main.java.com.kamazon.application.port.ProductDto;
import main.java.com.kamazon.application.port.UserDto;
import main.java.com.kamazon.domain.enums.ProductCategory;
import main.java.com.kamazon.domain.enums.UserRole;

import java.util.Scanner;

public class AdminView {

    Scanner sc = new Scanner(System.in);

    public int startAdminMenu(String adminName) {
        System.out.println("HELLO, " + adminName.toUpperCase());
        System.out.println("1. Add user");
        System.out.println("2. Add product");
        System.out.println("3. Make purchase");
        System.out.println("4. Return purchase");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println("------------------------------------------");
        return option;
    }

    public UserDto askForUser () {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.println("Role: ");
        String roleInput = sc.nextLine();

        UserRole role = null;
        try {
            role = UserRole.valueOf(roleInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role. Use: ADMIN or CLIENT");
        }

        Double balance;
        if (role == UserRole.ADMIN) {
            balance = null;
        } else {
            System.out.println("Balance: ");
            balance = sc.nextDouble();
        }

        return new UserDto(name, email, password, role, balance);
    }

    public ProductDto askForProduct() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        sc.nextLine(); // Cleans buffer
        System.out.print("Category: ");
        String categoryInput = sc.nextLine().toUpperCase();

        ProductCategory category;
        try {
            category = ProductCategory.valueOf(categoryInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category. Use: ELECTRONICS, CLOTHING, SPORT, GAMING, BOOKS");
            return null;
        }

        System.out.print("Stock: ");
        int stock = sc.nextInt();
        sc.nextLine(); // Cleans buffer
        System.out.print("Rating: ");
        double rating = sc.nextDouble();
        sc.nextLine(); // Cleans buffer

        return new ProductDto(name, price, category, stock, rating);
    }
}
