package module1Conditionals.exercises.easyLevel;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
//        3o.- Repetir el ejercicio 1o de este bloque de ejercicios, pero pidiendo al usuario cinco
//        variables. Es decir, se pedirán al usuario cinco variables y se mostrará el mayor valor en
//        pantalla.

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

        if(num1 > num2 && num1 > num3 && num1 > num4 && num1 > num5) {
            System.out.println("The biggest number is " + num1);

        } else if (num2 > num1 && num2 > num3 && num2 > num4 && num2 > num5) {
            System.out.println("The biggest number is " + num2);

        } else if (num3 > num2 && num3 > num1 && num3 > num4 && num3 > num5) {
            System.out.println("The biggest number is " + num3);

        } else if(num4 > num2 && num4 > num3 && num4 > num1 && num4 > num5) {
            System.out.println("The biggest number is " + num4);

        } else if(num5 > num2 && num5 > num3 && num5 > num4 && num5 > num1) {
            System.out.println("The biggest number is " + num5);

        } else {
            System.out.println("An error occurred");
        }
    }
}
