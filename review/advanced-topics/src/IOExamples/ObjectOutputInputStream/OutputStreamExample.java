package IOExamples.ObjectOutputInputStream;

import java.io.*;
import java.util.*;

public class OutputStreamExample {
    static void main() throws IOException {
//        userByteInput();
        userStringInput();
    }

    /**
     * Allows a user to write the ascii bytes of each letter to
     * create a word / phrase in a new text file
     * @throws IOException
     */
    private static void userByteInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        OutputStream fos = new FileOutputStream("src/IOExamples/phrase.txt");
        ArrayList<Byte> arrayList = new ArrayList<>();
        byte input;

        do {
            System.out.print("Introduce a number or character from th ASCII table: ");
            input = sc.nextByte();
            arrayList.add(input);
        } while (input != 0);

        for (int i : arrayList) { fos.write(i); }
        fos.flush();
        fos.close();
    }

    /**
     * Converts bytes to their ascii character, creating a string
     * @param arrayList
     * @return
     */
    private static String bytesToString(ArrayList<Byte> arrayList) {
        byte[] b = new byte[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) { b[i] = arrayList.get(i); }
        return new String(b);
    }

    /**
     * Allows the user to write a string and translate it via bytes
     * inside a new text file
     * @throws IOException
     */
    private static void userStringInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        OutputStream fos = new FileOutputStream("src/IOExamples/phrase.txt");
        byte[] b;

        System.out.print("Write a phrase: ");
        String message = sc.nextLine();
        sc.close();

        b = stringToBytes(message);
        for (int i = 0; i < b.length; i++) { fos.write(b[i]); }
        fos.flush();
        fos.close();
    }


    /**
     * Converts a String into bytes that gets storaged into a byte array
     * being each letter the corresponding ascii byte
     * @param str
     * @return
     */
    private static byte[] stringToBytes(String str) {
        byte[] b = new byte[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            b[i] = (byte) c;
        }

        return b;
    }
}
