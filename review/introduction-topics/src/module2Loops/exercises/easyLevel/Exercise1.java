package module2Loops.exercises.easyLevel;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
//        1o.- Realiza un programa que pida al usuario cuatro números enteros, y calcule la suma solo
//        de aquellos números introducidos por el usuario, que sean mayores de 10. Es decir, que si el
//        usuario introduce el 5, el 15, el 6 y el 25, el programa debe calcular la suma solo de 15 más
//        25, ya que 5 y 6 son menores de 10.

        Scanner sc = new Scanner(System.in);

        int num = 0, total = 0;

        for(int i = 0; i < 4; i++) {
            System.out.print("Introduce a number: ");
            num = sc.nextInt();

            if(num > 10) {
                total += num;
            }
        }

        System.out.println("The result is " + total);
    }
}
