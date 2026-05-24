package module1Conditionals.exercises.easyLevel;

import java.util.Scanner;

public class Exercise1 {
//    1o.- Realiza un ejercicio que pida dos variables al usuario, tras lo cual, muestre en pantalla el
//    número mayor de los dos introducidos.

    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);

        System.out.print("Introduce a number: ");
        int num1 = sc.nextInt();

        System.out.print("Introduce another number: ");
        int num2 = sc.nextInt();

        if(num1 > num2) {
            System.out.println("The biggest number is " + num1);

        } else if (num1 < num2) {
            System.out.println("The biggest number is " + num2);

        } else {
            System.out.println("Both numbers are equal");
        }
    }
}
