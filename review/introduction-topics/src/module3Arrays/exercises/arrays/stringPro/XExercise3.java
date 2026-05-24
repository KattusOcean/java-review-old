package module3Arrays.exercises.arrays.stringPro;

import java.util.Scanner;

public class XExercise3 {
    public static void main(String[] args) {
//        3.- Contar ocurrencias .Crea un método que cuente cuántas veces aparece una subcadena en
//        una cadena dada.

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce a phrase: ");
        String str = sc.nextLine();
        System.out.print("Introduce a word to search: ");
        String subStr = sc.nextLine();
        sc.close();

        countOccurrence(str, subStr);
    }

    public static void countOccurrence(String str, String subStr) {
        int totalOccurrences = 0;
        int index = 0;

        while ((index = str.indexOf(subStr, index)) != -1) {

        }
    }
}
