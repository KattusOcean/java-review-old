package module3Arrays.exercises.arrays.begginer;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
//        2.- Desde "main" lee una cadena de caracteres (String) del usuario, con Scanner o
//        JOptionPane. Envía la cadena de caracteres a un método que cuente y muestre en consola
//        cuántas vocales y consonantes hay en el texto. En la cadena de caracteres no debe haber
//        vocales con tilde o 'ñ'.

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce a word: ");
        String word = sc.nextLine();
        countVocalsAndConsonants(word);
    }

    public static void countVocalsAndConsonants(String string) {
        int totalVoc = 0, totalCons = 0;
        String voc = "aeiouAEIOU";
        String nonValiLetters = "áéíóúÁÉÍÓÚñ";

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (Character.isLetter(c)) {
                if (voc.indexOf(c) != -1) {
                    if (nonValiLetters.indexOf(c) == -1){
                        totalVoc += 1;
                    }
                }  else {
                    if(nonValiLetters.indexOf(c) == -1) {
                        totalCons += 1;
                    }
                }
            }
        }

        System.out.printf("+ Vocales: %d\n", totalVoc);
        System.out.printf("- Consonantes: %d", totalCons);
    }
}
