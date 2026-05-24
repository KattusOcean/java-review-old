package module2Loops.exercises.mediumLevel.whileExercises;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
//        3o.- Crea un ejercicio que imprima en pantalla todas las tablas de multiplicar desde el 1 hasta
//        el 15. Debes utilizar únicamente bucles de tipo "do...while".

        Scanner sc = new Scanner(System.in);

        int num = 1;

        do {
            int i = 0;
            System.out.println("=== TABLE OF " + num + " ===");

            do {
                int total = num * i;
                System.out.println(num + " * " + i + " = " + total);
                i++;
            } while (i <= 10);

            System.out.println(" ");
            num++;
        } while (num <= 15);
    }
}
