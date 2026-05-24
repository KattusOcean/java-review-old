package module3Arrays.exercises.arrays.begginer;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
    //    1.- Desde "main" lee una cadena de caracteres (String) del usuario, con Scanner o
    //    JOptionPane. Envía la cadena de caracteres a un método que muestre dicha cadena en orden
    //    inverso

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce a word: ");
        String word = sc.nextLine();
        sc.close();

        System.out.println("--- Original Word ---");
        System.out.println(word);
        System.out.println("--- Reversed Word ---");
        reverseString(word);
        System.out.println("--- Reversed Word By Method ---");
        reversedStringByMethod(word);
    }

    public static void reverseString(String string) {
        String reversed = "";
        char c;

        for (int i = 0; i < string.length(); i++) {
            c = string.charAt(i);
            reversed = c + reversed;
        }

        System.out.println(reversed);
    }

    public static void reversedStringByMethod(String string) {
        StringBuilder rString = new StringBuilder();
        rString.append(string);
        rString.reverse();
        System.out.println(rString);
    }
}
