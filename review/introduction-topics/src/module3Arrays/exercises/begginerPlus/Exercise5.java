package module3Arrays.exercises.begginerPlus;

import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
//    5º.- Realiza un ejercicio igual al anterior, pero en el que el usuario pueda indicar la cantidad de
//    posiciones que deseamos desplazar. Debes realizar el ejercicio mediante un método que
//    admita el array como argumento, un número entero indicando el número de posiciones que se
//    debe desplazar y realice la acción pedida. Cabecera del método 'public static void
//    desplazaCiclicoDerecha (int a[], int posiciones)'

        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];

        System.out.print("How many positions to the right?: ");
        int positions = sc.nextInt();

        System.out.println("--- Original Array ---");
        for (int i = 0; i < array.length; i++) {
           int rand = (int) Math.round(Math.random() * 10);
           array[i] = rand;
           System.out.printf(array[i] + "\t");
       }

        System.out.println("\n--- Modified Array ---");
       moveElementPositionToRight(array, positions);
    }

    public static void moveElementPositionToRight(int[] array, int positions) {
        int[] arrayAux = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int newPos = (i + positions) % array.length;
            arrayAux[newPos] = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = arrayAux[i];
            System.out.printf(array[i] + "\t");
        }
    }
}
