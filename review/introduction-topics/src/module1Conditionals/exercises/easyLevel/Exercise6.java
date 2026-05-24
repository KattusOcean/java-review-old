package module1Conditionals.exercises.easyLevel;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
//        6o.- Realizar un ejercicio en Java que pida un número al usuario e indique en pantalla si se
//        trata de un número par o impar. Recuerda que un número par es aquel cuyo resto de su
//        división entre dos sea siempre cero, y recuerda que un número impar es aquel cuyo resto de
//        su división entre dos sea siempre uno.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a number: ");
        int num = sc.nextInt();

        if(num % 2 == 0) {
            System.out.println("Number is par!");

        } else {
            System.out.println("Number is odd!");
        }
    }
}
