package module2Loops.exercises.highLevel.forExercises;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
//        1o.- Realiza un ejercicio que pida números al usuario. El programa debe detenerse cuando el
//        usuario introduzca el número 0 (cero), que no debe tenerse en cuenta para ninguna
//        operación aritmética, simplemente para salir de la aplicación. Cuando el programa haya
//        terminado, se debe sacar en pantalla el valor de la suma y de la media de todos los
//        números.

        Scanner sc = new Scanner(System.in);

        int num, counter = 0, total = 0;

        do {
            System.out.print("Introduce a number: ");
            num = sc.nextInt();
            total += num;
            counter += 1;
        } while (num != 0);

        float avg = (float) total / (counter - 1);

        System.out.println("The sum is " + total);
        System.out.println("The average is " + avg);
    }
}
