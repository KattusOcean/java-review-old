package module1Conditionals.exercises.easyLevel;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
    //    2o.- Repetir el ejercicio anterior para mostrar el número menor de los dos introducidos .

        Scanner sc = new Scanner(System.in);

        System.out.print("Intrduce a number: ");
        int num1 = sc.nextInt();

        System.out.print("Introduce another number: ");
        int num2 = sc.nextInt();

        if(num1 > num2) {
            System.out.println("The lowest number is " + num2);

        } else if (num1 < num2) {
            System.out.println("The lowest number is " + num1);

        } else {
            System.out.println("Both numbers are equal");
        }
    }
}
