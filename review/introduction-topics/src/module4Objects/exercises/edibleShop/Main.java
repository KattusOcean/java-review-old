package module4Objects.exercises.edibleShop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code, name, type, date;
        float price;

        Shop shop = new Shop();
        for (int i = 0; i < 4; i++) {
            System.out.println("=== PRODUCT DATA Nº" + (i+1) + " ===");
            System.out.print("Introduce the code: ");
            code = sc.nextLine();
            System.out.print("Introduce the name: ");
            name = sc.nextLine();
            System.out.print("Introduce the price: ");
            price = sc.nextFloat();
            System.out.print("Is perishable (y/n)?: ");
            type = sc.next();
            sc.nextLine();

            if (type.equalsIgnoreCase("y")) {
                System.out.print("Introduce the expire date: ");
                date = sc.nextLine();
                System.out.println(" ");

                Perishable p = new Perishable (code, name, price, date);
                shop.addProduct(p);

            } else {
                System.out.println(" ");
                NonPerishable np = new NonPerishable(code, name, price);
                shop.addProduct(np);
            }
        }
        shop.listProducts();
    }
}
