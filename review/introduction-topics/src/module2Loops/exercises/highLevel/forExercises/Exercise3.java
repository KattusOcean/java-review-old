package module2Loops.exercises.highLevel.forExercises;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
//        3o.- Realiza un ejercicio que pida números al usuario, hasta que uno de ellos sea 0 (cero).
//        Para cada número introducido se debe mostrar en pantalla su tabla de multiplicar, desde el 0
//        (cero) hasta el 10.

        Scanner sc = new Scanner(System.in);

        int num = 0, total = 0;

        for(int i = 0; i >= 0; i++) {

            System.out.print("Introduce a number: ");
            num = sc.nextInt();

            for(int j = 0; j <= 10; j++) {
                total = num * j;
                System.out.print(num + " * " + j + " = " + total + "\n");
            }
            System.out.println(" ");
        }
    }
}
