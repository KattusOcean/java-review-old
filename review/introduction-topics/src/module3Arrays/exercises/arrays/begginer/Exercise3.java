package module3Arrays.exercises.arrays.begginer;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
//        3.- Desde "main" lee una cadena de caracteres (String) del usuario, con Scanner o
//        JOptionPane. Envía la cadena de caracteres a un método que devuelva un valor booleano,
//        indicando si la cadena de caracteres se trata de un palíndromo (se lee igual al derecho que al
//        revés, como "radar". No escribas tildes.

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce a word: ");
        String word = sc.nextLine();

        boolean reversed = isPalindrome(word);

        if (reversed) { System.out.println("The word is palindrome"); }
        else { System.out.println("The word is not palindrome"); }
    }

    public static boolean isPalindrome(String string) {
        string = string.toLowerCase();
        String reversed = "";

        for (int i = string.length() - 1; i >= 0; i--) {
            reversed += string.charAt(i);
        }

        return string.equals(reversed);
    }
}
