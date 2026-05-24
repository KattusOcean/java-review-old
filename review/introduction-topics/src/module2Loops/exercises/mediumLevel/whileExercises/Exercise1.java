package module2Loops.exercises.mediumLevel.whileExercises;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
//        1o.- Crea un programa que compruebe si un número es primo o no. Debes pedir al usuario un
//        número y después informar de si se trata de un número primo o compuesto. Tienes prohibido
//        el uso del bucle "for".

        Scanner sc = new Scanner(System.in);

        boolean isPrime = true;

        do {
            System.out.print("Introduce a number: ");
            int num = sc.nextInt();

            if(num <= 1) {
                isPrime = false;

            } else {
                int i = 2;
                while (i * i <= num) {
                    if(num % 2 == 0) {
                        isPrime = false;
                        break;
                    }

                    i++;
                }
            }

            System.out.println("Number " + num + " is prime? -> " + isPrime);

        } while (isPrime);
    }
}
