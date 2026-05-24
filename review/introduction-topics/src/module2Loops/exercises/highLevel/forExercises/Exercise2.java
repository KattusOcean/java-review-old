package module2Loops.exercises.highLevel.forExercises;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
//        2o.- Realiza un ejercicio que pida números al usuario hasta que este introduzca el 0 (cero). Al
//        finalizar el ejercicio se debe imprimir en pantalla el valor mayor y el menor introducido. El
//        valor 0 (cero) no debe tenerse en cuenta.

        Scanner sc = new Scanner(System.in);

        int num, aux = 0, min = 999999, max = -999999;

        do {
            System.out.print("Introduce a number: ");
            num = sc.nextInt();

            if(num != 0) {
                aux = num;
            }

            if(aux < min) {
                min = aux;

            } else if (aux > max) {
                max = aux;
            }
        } while(num != 0);

        System.out.println("The biggest number is: " + max);
        System.out.println("The lowest number is: " + min);
    }
}
