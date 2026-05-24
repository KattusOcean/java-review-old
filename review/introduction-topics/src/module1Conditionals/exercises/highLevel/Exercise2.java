package module1Conditionals.exercises.highLevel;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
//        2o.- Realiza una calculadora avanzada, pero con la particularidad de que las operaciones
//        deben ser raices, potencias y el módulo de la división.

        Scanner sc = new Scanner(System.in);

        System.out.println("    === MENU ===");
        System.out.println("1.- Root");
        System.out.println("2.- Power");
        System.out.println("3.- Module");
        System.out.print("Select an option: ");
        int option = sc.nextInt();

        if(option == 1) {
            System.out.print("Introduce a number: ");
            int rootNum = sc.nextInt();

            System.out.println("The root of " + rootNum + " is -> " + Math.sqrt(rootNum));

        } else if (option == 2) {
            System.out.print("Introduce a number: ");
            int baseNum = sc.nextInt();
            System.out.print("Introduce the power number: ");
            int powerNum = sc.nextInt();

            System.out.println("The result of " + baseNum + "^" + powerNum + " is -> " + Math.pow(baseNum, powerNum));

        } else if (option == 3) {
            System.out.print("Introduce a number: ");
            int moduleNum = sc.nextInt();

            System.out.println("The module of " + moduleNum + " is -> " + (moduleNum % 2));

        } else {
            System.out.println("Please, select a valid option");
        }
    }
}
