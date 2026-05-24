package IOExamples.BufferedOutputInputStream;

import javax.imageio.stream.IIOByteBuffer;
import java.io.*;

public class BufferedOutputStreamExample {
    static void main() {
        writeString();
        readString();
    }

    // BufferedStream... is always better than O.../I...Stream because does a lot less calls meaning
    // the disc doesn't work as much and the response is quicker
    private static void writeString() {
        try (FileOutputStream fos = new FileOutputStream("src/IOExamples/BufferedOutputInputStream/message.bin");
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            for (int i = 0; i <= 255; i++) { oos.writeUTF("#Im_too_strong_to_DIE!" + i + "\n"); }
            oos.flush();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readString() {
        try (FileInputStream fis = new FileInputStream("src/IOExamples/BufferedOutputInputStream/message.bin");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis)) {

            while (true) { System.out.println(ois.readUTF()); }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
