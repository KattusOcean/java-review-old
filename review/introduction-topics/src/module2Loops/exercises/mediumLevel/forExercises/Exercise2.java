package module2Loops.exercises.mediumLevel.forExercises;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
//        2o.- Mayor y menor de una cantidad de números dada por el usuario. El usuario introducirá
//        una cantidad de números, tras lo cual se le deben pedir tantos como este haya indicado. Al
//        final se debe imprimir el mayor y el menor de todos los introducidos.

        Scanner sc = new Scanner(System.in);

        int min = 0, max = 0;

        System.out.print("How many numbers do you need?: ");
        int limit = sc.nextInt();

        for(int i = 0; i < limit; i++) {
            System.out.print("Introduce a number: ");
            int num = sc.nextInt();

            int aux = num;

            if(aux < 0) {
                min = aux;

            } else if (aux > 0) {
                max = aux;
            }
        }

        System.out.println("-----------------------");

        System.out.println("The max number is " + max);
        System.out.println("The min number is " + min);
    }
}
