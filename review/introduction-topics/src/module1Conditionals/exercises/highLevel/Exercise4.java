package module1Conditionals.exercises.highLevel;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
//        4o.- Escribe un programa que lea el importe de una compra y la cantidad recibida y calcule el
//        cambio a devolver, teniendo en cuenta que el número de monedas que se devuelven debe
//        ser mínimo. Suponer que el sistema monetario utilizado consta de monedas de 100, 50, 25,
//        5, y 1 unidad. El precio viene dado en unidades monetarias enteras.
//
//        Ejemplo: Pagamos con 2000 unidades monetarias un articulo que nos cuesta 375 unidades
//        monetarias, la vuelta (1625 u) debería de ser de la siguiente forma:
//        - 16 monedas de 100 = 1600 - 1 moneda de 25 = 25

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce the matter: ");
        int matter = sc.nextInt();
        System.out.print("Introduce the quantity given: ");
        int quantity = sc.nextInt();

        int toGive = quantity - matter;
        System.out.println("Total to give: " + toGive + "\n");

        int oneCoin = 0, fiveCoin = 0, tenCoin = 0, twentyFiveCoin = 0, fiftyCoin = 0, hundredCoin = 0;

        do {
            if (toGive % 100 == 0) {
                hundredCoin += 1;
                toGive = toGive - 100;

            } else if (toGive % 50 == 0) {
                fiftyCoin += 1;
                toGive = toGive - 50;

            } else if (toGive % 25 == 0) {
                twentyFiveCoin += 1;
                toGive = toGive - 25;

            } else if (toGive % 10 == 0) {
                tenCoin += 1;
                toGive = toGive - 10;

            } else if (toGive % 5 == 0) {
                fiveCoin += 1;
                toGive = toGive - 5;

            } else if (toGive % 1 == 0) {
                oneCoin += 1;
                toGive = toGive - 1;
            }
        } while (toGive > 0);

        System.out.println("=== TO GIVE ===");
        System.out.println("* 100: " + hundredCoin);
        System.out.println("* 50: " + fiftyCoin);
        System.out.println("* 25: " + twentyFiveCoin);
        System.out.println("* 10: " + tenCoin);
        System.out.println("* 5: " + fiftyCoin);
        System.out.println("* 1: " + oneCoin);
    }
}
