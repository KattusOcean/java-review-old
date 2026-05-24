package module3Arrays.exercises.arrays.begginer;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
//        5.- Desde "main" lee dos cadenas de caracteres (String) del usuario, con Scanner o
//        JOptionPane. Envía las cadenas de caracteres a un método que las admitirá con los nombres
//        "string1" y "string2". El método debe comparar las dos cadenas de forma lexicográfica y
//        devolver: -1 si "string1" es menor que "string2"; 1 si "string1" es mayor que "string2"; 0 si las
//        dos cadenas son iguales. No uses vocales con tilde o 'ñ

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a phrase: ");
        String s1 = sc.nextLine();
        System.out.print("Introduce another phrase: ");
        String s2 = sc.nextLine();
        sc.close();

        compareStringByLength(s1, s2);

        if (compareStringByLength(s1, s2) == 1) { System.out.println("The first phrase was larger"); }
        else if (compareStringByLength(s1, s2) == -1) { System.out.println("The second phrase was larger"); }
        else if (compareStringByLength(s1, s2) == 0) { System.out.println("Both phrases are the same length"); }
        else System.out.println("An error occurred!");

    }

    public static int compareStringByLength (String s1, String s2) {

        String nonValueCharacters = " ñáéíóúÁÉÍÓÚ";
        int s1Length = 0, s2Length = 0;
        char c;

        for (int i = 0; i < s1.length(); i++) {
            c = s1.charAt(i);

            if (nonValueCharacters.indexOf(c) == -1) {
                s1Length += 1;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            c = s2.charAt(i);

            if (nonValueCharacters.indexOf(c) == -1) {
                s2Length += 1;
            }
        }

        if (s1Length > s2Length) {return 1; }
        else if (s1Length < s2Length) { return -1; }
        else { return 0; }
    }
}
