package module2Loops.exercises.mediumLevel.whileExercises;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
//        2o.- Crea un programa que compruebe si son primos o compuestos todos los números entre
//        un límite inferior y uno superior que debes pedir al usuario. Tienes prohibido el uso del bucle
//        "for"

        Scanner sc = new Scanner(System.in);

        System.out.print("Declare the minimum limit: ");
        int minLimit = sc.nextInt();

        System.out.print("Declare the maximum limit: ");
        int maxLimit = sc.nextInt();

        boolean isPrime = true;
        int num = minLimit;

        do {
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
            num++;

        } while (num <= maxLimit);
    }
}
