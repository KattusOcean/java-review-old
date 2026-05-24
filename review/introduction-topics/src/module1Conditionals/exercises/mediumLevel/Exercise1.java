package module1Conditionals.exercises.mediumLevel;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
//        1o.- Realiza un ejercicio que acumule cinco números introducidos por el usuario, es decir, que
//        sume las cantidades introducidas, pero realizando cuatro categorías: números negativos,
//        números bajos (entre 0 y 25, ambos inclusive), números medios (entre 26 y 250, ambos
//        inclusie) y números grandes (mayores de 250). Al finalizar el programa, se debe mostrar el
//        total de las sumas de los números introducidos en cada una de las categorías.

        Scanner sc = new Scanner(System.in);

        int negTotal = 0, lowTotal = 0, midTotal = 0, highTotal = 0;

        for(int i = 0; i < 5; i++) {
            System.out.print("Introduce a number: ");
            int num = sc.nextInt();

            if(num < 0) {
                negTotal += num;

            } else if (num >= 0 && num <= 25 ) {
                lowTotal += num;

            } else if (num > 25 && num <= 250 ) {
                midTotal += num;

            } else if (num > 250) {
                highTotal += num;
            }
        }

        System.out.println("----------------------------------");

        System.out.println("Negative total: " + negTotal);
        System.out.println("Low total: " + lowTotal);
        System.out.println("Mid total: " + midTotal);
        System.out.println("High total: " + highTotal);

    }
}
