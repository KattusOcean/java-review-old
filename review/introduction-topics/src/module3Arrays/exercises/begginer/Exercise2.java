package module3Arrays.exercises.begginer;

import java.util.Scanner;

public class Exercise2 {
//    2º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre un límite
//    inferior y uno superior que debe especificar el usuario. Debes mostrar el array en pantalla para
//    comprobar el funcionamiento

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[150];
        int max = 0, min = 0;

        System.out.print("Max limit: ");
        max = sc.nextInt();
        System.out.print("Min limit: ");
        min = sc.nextInt();

        for (int i = 0; i < numbers.length; i++) {
            int rand = (int) Math.round(Math.random() * (max - min));
            numbers[i] = rand;
            System.out.printf("%d.- %d\n", i, numbers[i]);
        }
    }
}
