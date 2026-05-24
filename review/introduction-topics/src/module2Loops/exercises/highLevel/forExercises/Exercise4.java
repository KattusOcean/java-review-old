package module2Loops.exercises.highLevel.forExercises;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
//        4o.- Realiza un ejercicio que pida números al usuario, hasta que uno de ellos sea 0 (cero). Al
//        finalizar se debe imprimir en pantalla cuantos son positivos y cuantos negativos. No debes
//        tener en cuenta el 0 (cero).

        Scanner sc = new Scanner(System.in);

        int negNums = 0, posNums = 0;

        for(int i = 0; i >= 0; i++) {
            System.out.print("Introduce a number: ");
            int num = sc.nextInt();

            if(num < 0) {
                negNums += 1;

            } else if(num > 0){
                posNums += 1;

            } else {
                break;
            }
        }

        System.out.println("--------------------------");
        System.out.println("+ Positive numbers: " + posNums);
        System.out.println("+ Negative numbers: " + negNums);
    }
}
