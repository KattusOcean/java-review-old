package UL;

import java.util.Scanner;

public class WeightConverter {
    static void main() {

        Scanner sc = new Scanner(System.in);

        double kg, lb, result;
        int option;

        System.out.println("--- OPTIONS ---");
        System.out.println("1.- Kg to Lb");
        System.out.println("2.- Lb to Kg");
        System.out.print("Introduce an option: ");
        option = sc.nextInt();

        if (option == 1) {
            System.out.print("Introduce the kg: ");
            kg = sc.nextFloat();
            result = kg * 2.20462;
            System.out.println("The weight is " + result + "lb");
        } else {
            System.out.print("Introduce the lb: ");
            lb = sc.nextFloat();
            result = lb * 0.453592;
            System.out.println("The weight is " + result + "kg");
        }

    }
}
