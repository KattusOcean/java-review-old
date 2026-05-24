package module2Loops.exercises.mediumLevel.forExercises;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
//        3o.- Ejercicio que obtenga todos los múltiplos de un número introducido por el usuario. Se
//        imprimirán todos los múltiplos menores de 100, este será el límite.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a number: ");
        int num = sc.nextInt();

        for(int i = 0; i <= 100; i++) {
            int result = num * i;
            System.out.println(num + " * " + i + " = " + result);
        }
    }
}
