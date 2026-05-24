package IOExamples.ComplexReaderWriter;

import java.io.*;

public class Main {
    static void main() {
//        complexReader();
        complexWriter();
    }

    private static void complexReader() {
        try (Reader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r)) {
            System.out.println(br.readLine());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void complexWriter() {
        try (Writer w = new OutputStreamWriter(System.out);
            BufferedWriter bw = new BufferedWriter(w)) {
            w.write("Holaaaa");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
