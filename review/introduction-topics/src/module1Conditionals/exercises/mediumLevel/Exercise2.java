package module1Conditionals.exercises.mediumLevel;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
//        2o.- Realiza un ejercicio igual al anterior, pero al acabar, el programa no debe mostrar la
//        suma de los números, sino cuantos han entrado en cada categoría. A esto se llema
//        contadores, a diferencia del ejercicio anterior, que reciben el nombre de acumuladores.

        Scanner sc = new Scanner(System.in);

        int negCount = 0, lowCount = 0, midCount = 0, highCount = 0;

        for(int i = 0; i < 5; i++) {

            System.out.print("Introduce a number: ");
            int num = sc.nextInt();

            if(num < 0) {
                negCount += 1;

            } else if (num >= 0 && num <= 25) {
                lowCount += 1;

            } else if (num > 25 && num <= 250) {
                midCount += 1;

            } else if (num > 250) {
                highCount += 1;
            }
        }

        System.out.println("---------------------------");

        System.out.println("Neg counter: " + negCount);
        System.out.println("Low counter: " + lowCount);
        System.out.println("Mid counter: " + midCount);
        System.out.println("High counter: " + highCount);

    }
}
