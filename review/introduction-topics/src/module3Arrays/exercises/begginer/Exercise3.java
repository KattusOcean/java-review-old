package module3Arrays.exercises.begginer;

import java.util.Scanner;

public class Exercise3 {
    public static void main (String[] args) {
//        3º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
//        Después de su inicialización debéis imprimir el array en orden inverso.

        int[] nums = new int[150];

        System.out.print("----- CORRECT -----\n");
        for (int i = 0; i < nums.length; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            nums[i] = rand;
            System.out.printf("Number %d = %d\n", i, nums[i]);
        }

        System.out.print("\n----- REVERSED -----\n");
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.printf("Number %d = %d\n", i, nums[i]);
        }
    }
}
