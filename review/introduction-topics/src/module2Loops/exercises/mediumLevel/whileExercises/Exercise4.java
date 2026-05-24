package module2Loops.exercises.mediumLevel.whileExercises;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
//        4o.- Crea un programa que pida al usuario un número e imprima ese número en binario.
//        Tienes prohibido el uso del bucle "for".

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a number: ");
        int num = sc.nextInt();

        String binary = "";

        while (num != 0) {
            int remainder = num % 2;      // Guardamos el resto
            num = num / 2;                // Se recalcula un nuevo numero
            binary += remainder;          // Sumamos los restos al número binario actual
        }

        if (binary.equals("")) {
            binary = "0";                 // Si el numero introducido es 0, el binario será este
        }

        System.out.println("The binary code is " + Integer.parseInt(binary));
    }
}
