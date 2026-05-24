package module2Loops.exercises.highLevel.whileExercises;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
//        1.- Desarrolla un programa que sume los dígitos de un número entero.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a number: ");
        int num = sc.nextInt();


        String chain = String.valueOf(num);

        System.out.println(chain.length());
    }
}
