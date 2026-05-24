package utils;

import java.util.Scanner;

public class UtilsStrings {
    public static String generateString() {
        Scanner sc = new Scanner(System.in);

        String words = " -ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randStr = "";

        System.out.print("How long should it be?: ");
        int length = sc.nextInt();

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * words.length());
            randStr += words.charAt(index);
        }

        return randStr;
    }
}
