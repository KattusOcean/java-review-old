package module2Loops.exercises.easyLevel;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
//        2o.- Modifica el ejercicio anterior de manera que, en lugar de que el programa siempre pida
//        cuatro números, sea el usuario el que decida cuantos números se van a pedir.

        Scanner sc = new Scanner(System.in);

        int total = 0;

        System.out.print("How many numbers are you going to introduce?: ");
        int limit = sc.nextInt();

        for(int i = 0; i < limit; i++) {
            System.out.print("Introduce a number: ");
            int num = sc.nextInt();

            if(num > 10) {
                total += num;
            }
        }

        System.out.println("The result is " + total);
    }
}
