package module2Loops.exercises.mediumLevel.whileExercises;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
//        5o.- Calcula el factorial de un número dado por el usuario. Debes usar sólo el bucle while.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a number: ");
        int num = sc.nextInt();

        int lowerNumb = num -1;
        int result;

        // Mientras que el número no llegue a 0 se ejecuta el bucle
        do {
            result = num * (lowerNumb);          // El resultado es la multiplicación del resultado anterior * (número original - 1)
            num = result;
            lowerNumb -= 1;                           // Restamos el número (5 - 1 = 4) para el siguiente ciclo
        } while (lowerNumb != 0);

        System.out.println("The result of the factorial is " + result);
    }

    // Solo funciona hasta ek 16 ya que int tiene de rango 2³¹ y float 2⁶⁴, para que funcionase bien se debería usar
    // un BigInteger que puede ocupar todo lo que se necesite en memoria
}
