package UL;

import java.util.Scanner;

public class ShoppingCart {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Which product do you want?: ");
        String product = sc.nextLine();

        System.out.print("What's the price?: ");
        float price = sc.nextFloat();

        System.out.print("How many do you want?: ");
        int quantity = sc.nextInt();

        System.out.println("\n=== Summary ===");
        System.out.println("Product/s: " + quantity + " " + product + "/s");
        System.out.println("Price: " + price + "€");
    }
}
