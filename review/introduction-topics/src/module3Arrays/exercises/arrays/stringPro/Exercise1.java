package module3Arrays.exercises.arrays.stringPro;

import java.util.Scanner;

import static utils.UtilsStrings.generateString;

public class Exercise1 {
    public static void main(String[] args) {
//        1.- Eliminar espacios en blanco en una cadena. Crea un método que tome una cadena y
//        elimine todos los espacios en blanco

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce a phrase with spaces: ");
        String str = sc.nextLine();
        sc.close();
        String newStr = deleteBlankSpaces(str);
        System.out.println(newStr);
    }

    public static String deleteBlankSpaces(String str) {
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr = str.replaceAll(" ", "");
            }
        }
        return newStr;
    }
}
