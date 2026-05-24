package module3Arrays.exercises.arrays.stringPro;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
//        2.- Cifrado César. Crea un método que tome una cadena y un número como argumentos, y
//        aplique el cifrado César a la cadena. El cifrado César consiste en mover cada letra en el
//        alfabeto por un número fijo. Por ejemplo, con un desplazamiento de 3, "hola" se convierte en
//        "krod".

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce a phrase: ");
        String text = sc.nextLine();
        System.out.print("Introduce a number to cipher: ");
        int num = sc.nextInt();
        sc.close();

        String code = caesarCipher(text, num);
        System.out.println("Code: " + code);
    }

    public static String caesarCipher(String rawText, int sequence) {
        String code = "";
        char c;

        for (int i = 0; i < rawText.length(); i++) {
            c = rawText.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c = (char) ('A' + (c - 'A' + sequence) % 26);

            } else if (c >= 'a' && c <= 'z') {
                c = (char) ('a' + (c - 'a' + sequence) % 26);
            }

            code += c;
        }
        return code;
    }
}
