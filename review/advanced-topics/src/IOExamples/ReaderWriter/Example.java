package IOExamples.ReaderWriter;

import java.io.*;

public class Example {
    static void main() {
        writeFile();
        readFile();
    }

    private static void writeFile() {
        try (Writer writer = new FileWriter("src/IOExamples/ReaderWriter/note.txt")) {
            writer.write("Hi, World!\n");
            writer.write(84 + "\n");
            writer.write("K");
            writer.append("A");
            writer.append("T");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readFile() {
        try (Reader reader = new FileReader("src/IOExamples/ReaderWriter/note.txt");
            BufferedReader br = new BufferedReader(reader)) {
            String ch;
            do {
                ch = br.readLine();
                if (ch != null) {
                    System.out.println(ch);
                }
            } while (ch != null);

        } catch (IOException e) {

        }
    }
}
