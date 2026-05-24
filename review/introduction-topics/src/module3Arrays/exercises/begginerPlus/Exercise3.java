package module3Arrays.exercises.begginerPlus;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
//        3º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
//        Debes conseguir multiplicar cada uno de los elementos del array por un número determinado,
//        pedido al usuario. Debes realizar el ejercicio mediante un método que admita el array como
//        argumento, además del número por el que multiplicar y realice la acción pedida. Cabecera del
//        método 'public static void multiplicaValoresPorFactor (int a[], int factor)

        Scanner sc = new Scanner(System.in);
        int[] array = new int[15];

        System.out.print("Introduce a number: ");
        int num = sc.nextInt();

        System.out.println("--- Array ---");
        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            array[i] = rand;
            System.out.print(array[i] + "\t");
        }

        System.out.println("\n--- Results ---");
        multiplyArrayByNum(array, num);
    }

    public static void multiplyArrayByNum(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= num;
            System.out.print(array[i] + "\t");
        }
    }
}
