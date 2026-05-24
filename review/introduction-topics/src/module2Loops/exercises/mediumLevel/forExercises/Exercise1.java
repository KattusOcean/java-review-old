package module2Loops.exercises.mediumLevel.forExercises;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
//        1o.- Media de una cantidad de números introducidos por el usuario. El usuario especificará
//        una cantidad de números, tras lo cual se le deben pedir tantos como este haya indicado. Al
//        final se debe imprimir la media.

        Scanner sc = new Scanner(System.in);

        int limit = 0, total = 0, avg = 0;

        System.out.print("How many numbers do you need?: ");
        limit = sc.nextInt();

        for(int i = 0; i < limit; i++) {
            System.out.print("Introduce a number: ");
            int num = sc.nextInt();

            total += num;
            avg = total / limit;
        }

        System.out.println("The average number is " + avg);
    }
}
