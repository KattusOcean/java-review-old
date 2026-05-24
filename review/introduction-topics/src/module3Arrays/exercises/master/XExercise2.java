package module3Arrays.exercises.master;

import java.util.Scanner;

public class XExercise2 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        2.- Realiza un programa que pida 10 números por teclado y que los almacene en un array. A
//        continuación se mostrará el contenido de ese array junto al índice (0 – 9). Seguidamente el
//        programa pedirá dos posiciones a las que llamaremos “inicial” y “final”. Se debe comprobar que
//        inicial es menor que final y que ambos números están entre 0 y 9. El programa deberá
//        desplazar todos los elementos del array a la derecha una posición, pero dejando intacto el
//        intervalo interior. Al final se debe mostrar el array resultante


        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 10);
            array[i] = rand;
        }

        System.out.print("Introduce a initial position (0-9): ");
        int start = sc.nextInt();
        System.out.print("Introduce a final position (0-9): ");
        int end = sc.nextInt();

        System.out.println("--- Original Array ---");
        showArray(array);
        System.out.println("\n--- Modified Array ---");
        moveToRightExcludingSection(array, start, end);
    }

    public static void moveToRightExcludingSection(int[] array, int start, int end) {
        if (start < end && start >= 0 && end < array.length) {
            int lastNum;

            if (array.length - 1 > end) { lastNum = array[array.length - 1]; }
            else { lastNum = array[start - 1]; }

            for (int i = start - 1; i > 0; i--) { array[i] = array[i - 1]; }
            for (int i = array.length - 1; i > end + 1; i--) { array[i] = array[i - 1]; }

            array[0] = lastNum;

            showArray(array);

        } else {
            System.out.println("Error: Invalid positions");
        }
    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
    }
}
