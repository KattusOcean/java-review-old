package module2Loops.exercises.easyLevel;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
//        3o.- Realiza un ejercicio que pida números al usuario, tantos como indique el usuario. al final
//        debe aparecer cuantos números positivos y negativos se han introducido.

        Scanner sc = new Scanner(System.in);

        int negNums = 0, posNumbs = 0;

        System.out.print("How many numbers are you going to introduce?: ");
        int limit = sc.nextInt();

        for(int i = 0; i < limit; i++) {
            System.out.print("Introduce positive or negative numbers: ");
            int num = sc.nextInt();

            if(num < 0) negNums += 1;
            else posNumbs += 1;
        }

        System.out.println("---------------------------");

        System.out.println("      === RESULT ===");
        System.out.println("+ Positive numbers: " + posNumbs);
        System.out.println("- Negative numbers: " + negNums);
    }
}
