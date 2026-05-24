package module3Arrays.exercises.begginer;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {

//        4º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
//        A continuación pedirás al usuario un valor y buscarás dicho valor en el array. Si lo encuentras,
//        debes indicar al usuario la posición del array en que se encuentra. En caso de que no
//        encuentres el valor buscado, debes indicárselo también al usuario.

        Scanner sc = new Scanner(System.in);
        int[] array = new int[150];

        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            array[i] = rand;
            System.out.printf("Num %d = %d\n", i, array[i]);
        }

        System.out.println("-----------------------------");
        System.out.print("Number between 0 and 100: ");
        int userNum = sc.nextInt();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == userNum) {
                System.out.printf("+ The number is in the %d position\n", i);
            } else {
                System.out.printf("- The number could not be found in the %d position\n", i);
            }
        }
    }
}
