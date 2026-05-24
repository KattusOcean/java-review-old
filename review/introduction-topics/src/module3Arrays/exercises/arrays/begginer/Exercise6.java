package module3Arrays.exercises.arrays.begginer;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
//        6.- Desde "main" lee una cadena de caracteres (String) del usuario, con Scanner o
//        JOptionPane. Envía la cadena de caracteres a un método que devuelva otra cadena de
//        caracteres, igual a la recibida pero en la que todas las letras mayúsculas se conviertan en
//        minúsculas. No debes usar vocales con tilde o 'ñ'. Puede ser de utilidad el siguiente enlace
//        https://elcodigoascii.com.ar/

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce a phrase: ");
        String str = sc.nextLine();
        sc.close();

        String reversedStr = revertCapitalization(str);
        System.out.print("Reversed phrase: " + reversedStr);
    }

    public static String revertCapitalization(String str) {
        String reversedStr = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isUpperCase(c)) {
                reversedStr += Character.toLowerCase(c);

            } else {
                reversedStr += Character.toUpperCase(c);
            }
        }

        return reversedStr;
    }
}
