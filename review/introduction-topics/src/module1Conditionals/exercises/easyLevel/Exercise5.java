package module1Conditionals.exercises.easyLevel;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
//        5o.- Pedir al usuario cinco números, e imprimir posteriormente el mayor valor introducido y el
//        menor valor introducido.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a number: ");
        int num1 = sc.nextInt();
        System.out.print("Introduce another number: ");
        int num2 = sc.nextInt();
        System.out.print("Introduce another number: ");
        int num3 = sc.nextInt();
        System.out.print("Introduce another number: ");
        int num4 = sc.nextInt();
        System.out.print("Introduce another number: ");
        int num5 = sc.nextInt();

        System.out.println("----------------------------");

        // Get the biggest number
        if(num1 > num2 && num1 > num3 && num1 > num4 && num1 > num5) {
            System.out.println("+ The biggest number is " + num1);

        } else if (num2 > num1 && num2 > num3 && num2 > num4 && num2 > num5) {
            System.out.println("+ The biggest number is " + num2);

        } else if (num3 > num2 && num3 > num1 && num3 > num4 && num3 > num5) {
            System.out.println("+ The biggest number is " + num3);

        } else if(num4 > num2 && num4 > num3 && num4 > num1 && num4 > num5) {
            System.out.println("+ The biggest number is " + num4);

        } else if(num5 > num2 && num5 > num3 && num5 > num4 && num5 > num1) {
            System.out.println("+ The biggest number is " + num5);

        } else {
            System.out.println("+ An error occurred");
        }

        // Get the lowest number
        if(num1 < num2 && num1 < num3 && num1 < num4 && num1 < num5) {
            System.out.println("- The lowest number is " + num1);

        } else if (num2 < num1 && num2 < num3 && num2 < num4 && num2 < num5) {
            System.out.println("- The lowest number is " + num2);

        } else if (num3 < num2 && num3 < num1 && num3 < num4 && num3 < num5) {
            System.out.println("- The lowest number is " + num3);

        } else if(num4 < num2 && num4 < num3 && num4 < num1 && num4 < num5) {
            System.out.println("- The lowest number is " + num4);

        } else if(num5 < num2 && num5 < num3 && num5 < num4 && num5 < num1) {
            System.out.println("- The lowest number is " + num5);

        } else {
            System.out.println("- An error occurred");
        }
    }
}
