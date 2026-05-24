package module3Arrays.exercises.arrays.begginer;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
//        4.- Desde "main" lee una cadena de caracteres (String) del usuario, con Scanner o
//        JOptionPane. Envía la cadena de caracteres a un método que devuelva el número de palabras
//        que contiene la cadena de caracteres. Piensa en que una palabra puede estar separada de
//        otra por una cantidad indeterminada de espacios en blanco.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a phrase: ");
        String phrase = sc.nextLine();

        countWords(phrase);
    }

    public static void countWords(String phrase) {
        int totalWords = 0;

        for (int i = 0; i < phrase.length(); i++) {
            if (i != 0) {
                if (phrase.charAt(i) == ' ' && phrase.charAt(i - 1) != ' ') {
                    totalWords += 1;

                } else if (i == phrase.length() - 1 && phrase.charAt(i) != ' ') {
                    totalWords += 1;
                }
            }
        }

        System.out.println("Total Words: " + totalWords);
    }
}
