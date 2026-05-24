package IOExamples.ObjectOutputInputStream;

import java.io.*;

public class InputStreamExample {
    static void main() throws IOException {
        System.out.println(byteToCharFromFile());
    }

    /**
     * Gets each byte of the file and converts them into their respective char
     * @return
     * @throws IOException
     */
    private static StringBuilder byteToCharFromFile() throws IOException {
        InputStream fis = new FileInputStream("src/IOExamples/phrase.txt");
        int i = 0, count = 0;
        byte ch;

        while (fis.read() != -1) { count++; }
        fis.close();

        fis = new FileInputStream("src/IOExamples/phrase.txt");
        byte[] b = new byte[count];
        while ((ch = (byte) fis.read()) != -1) {
            b[i] = ch;
            i++;
        }
        fis.close();

        return getTextFromFileChars(b);
    }

    /**
     * Appends the chars into a String that returns the original text before the byte conversion
     * @param b
     * @return
     */
    private static StringBuilder getTextFromFileChars(byte[] b) {
        StringBuilder sb = new StringBuilder();

        for (int i : b) {
            char ch = (char) i;
            sb = sb.append(ch);
        }

        return sb;
    }
}
