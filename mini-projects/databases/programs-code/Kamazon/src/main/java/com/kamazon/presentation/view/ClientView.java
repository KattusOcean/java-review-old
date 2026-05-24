package main.java.com.kamazon.presentation.view;

import main.java.com.kamazon.domain.enums.ProductCategory;

import java.util.Scanner;

public class ClientView {

    Scanner sc = new Scanner(System.in);

    // STARTS CLIENT GENERAL MENU
    public int startClientMenu(String clientName) {
        System.out.println("=== HELLO, " + clientName.toUpperCase() + " ===");
        System.out.println("1. Make purchase");
        System.out.println("2. Return purchase");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println("------------------------------------------");
        return option;
    }

    // STARTS PRE-PURCHASE MENU
    public int makePurchaseMenu() {
        System.out.println("=== SHOPPING CART [GENERAL] ===");
        System.out.println("1. Add product to cart");
        System.out.println("2. Remove product off cart");
        System.out.println("3. List current cart");
        System.out.println("4. Finish purchase!");
        System.out.println("0. Cancel purchase");
        System.out.print("Select an option: ");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println("------------------------------------------");
        return option;
    }

    // STARTS PRE-RETURN MENU
    public int returnPurchaseMenu() {
        System.out.println("=== SHOPPING CART [REMOVE] ===");
        System.out.println("1. Select product(s) to remove: ");
        System.out.println("0. Cancel removal");
        System.out.print("Select an option: ");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println("------------------------------------------");
        return option;
    }

    // SHOWS PRODUCTS OF A SELECTED CATEGORY
    public String showProductsByCategoryMenu() {

        ProductCategory category = null;

        while (category == null) {
            System.out.print("Introduce the category: ");
            String categoryInput = sc.nextLine();

            try {
                category = ProductCategory.valueOf(categoryInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category. Try again.");
            }
        }

        return String.valueOf(category);
    }

    // ASK FOR THE PRODUCT ID
    public int askProductId() {
        System.out.print("Introduce the product ID: ");
        return sc.nextInt();
    }

    // ASKS FOR THE PRODUCT QUANTITY
    public int askProductQuantity() {
        System.out.print("How many of them?: ");
        int quantity = sc.nextInt();

        if (quantity < 0) {
            System.out.print("Introduce a positive quantity: ");
            quantity = sc.nextInt();
        }

        return quantity;
    }

//    public boolean canProvideReceiptId() {
//        String canProvideId;
//
//        System.out.print("Can you provide the receipt id? (y/n): ");
//        canProvideId = sc.nextLine();
//
//        if (canProvideId.equalsIgnoreCase("y")) return true;
//        else if (canProvideId.equalsIgnoreCase("n")) return false;
//        return false;
//    }

    public Integer askForReceiptId() {
        System.out.print("Introduce the purchase receipt id: ");
        return sc.nextInt();
    }

    public void showNotes() {
        System.out.print("""
                > [NOTE]
                > Categories: TECHNOLOGY, CLOTHING, SPORT, FOOD, BOOKS
                > Stop: introduce 0
                """);
    }

    // EXITS PURCHASE / RETURN
    public void cancelOperation() {
        System.out.println("Aborting purchase / return ...");
        System.out.println("------------------------------------------");
    }

    // FOR CLIENT LOG OFF
    public void bye(String clientName) {
        System.out.println("=== BYE, " + clientName.toUpperCase() + "! ===");
        System.out.println("------------------------------------------");
    }
}
