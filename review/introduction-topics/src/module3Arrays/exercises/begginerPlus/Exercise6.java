package module3Arrays.exercises.begginerPlus;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
//        6º.- Realiza un ejercicio igual al anterior, en el que el usuario también pueda determinar la
//        dirección del movimiento. Debes realizar el ejercicio mediante un método que admita el array
//        como argumento, un número entero indicando el número de posiciones que se debe desplazar,
//        otro número que determine la dirección y realice la acción pedida. Cabecera del método 'public
//        static void desplazaCiclico (int a[], int posiciones, int direccion)'

        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];

        System.out.print("How many positions to move?: ");
        int positions = sc.nextInt();
        System.out.print("Introduce 0 (to left) or 1 (to right): ");
        int dir = sc.nextInt();

        System.out.println("--- Original Array ---");
        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 10);
            array[i] = rand;
            System.out.print(array[i] + "\t");
        }

        System.out.println("\n--- Modified Array ---");
        moveElementsInCycle(array, positions, dir);
    }

    public static void moveElementsInCycle(int[] array, int positions, int dir) {
        int[] arrayAux = new int[array.length];

        switch (dir) {
            case 0:
                for (int i = array.length - 1; i >= 0; i--) {
                    int newPos = (i - positions) % array.length;
                    if (newPos < 0) {
                        newPos += array.length;
                    }
                    arrayAux[newPos] = array[i];
                }
                showArray(array, arrayAux);
                break;

            case 1:
                for (int i = 0; i < array.length; i++) {
                    int newPos = (i + positions) % array.length;
                    arrayAux[newPos] = array[i];
                }
                showArray(array, arrayAux);
                break;

            default:
                System.out.println("An error happened");
                break;
        }
    }

    public static void showArray(int[] array, int[] arrayAux) {
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayAux[i];
            System.out.print(array[i] + "\t");
        }
    }
}
