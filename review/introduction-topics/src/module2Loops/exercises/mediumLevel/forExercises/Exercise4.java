package module2Loops.exercises.mediumLevel.forExercises;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
//        4o.- Reforma el ejercicio anterior, para que el límite sea también introducido por el usuario.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a number: ");
        int num = sc.nextInt();

        System.out.print("How many times do you want to multiply it?: ");
        int limit = sc.nextInt();

        int total = 0;

        for(int i = 0; i < limit; i++) {
            total = num * i;
            System.out.println(num + " * " + i + " = " + total);
        }
    }
}
