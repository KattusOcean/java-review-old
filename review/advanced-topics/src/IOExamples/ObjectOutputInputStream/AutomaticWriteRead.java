package IOExamples.ObjectOutputInputStream;

import java.io.*;
import java.util.ArrayList;

public class AutomaticWriteRead {
    static void main() {
        automaticConversion();
    }

    /**
     * Calls the write and read methods
     */
    private static void automaticConversion() {
        automaticWriteOutput();
        automaticReadOutput();
    }

    /**
     * Writes an output in the selected file
     */
    private static void automaticWriteOutput() {
        try (OutputStream fos = new FileOutputStream("src/IOExamples/object.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("Before");
            arr.add("After");
            arr.add("Now");
            Double x = 3.5;
            String str = "My name is Peppa Pig!";

            oos.writeObject(arr);
            oos.writeDouble(x);
            oos.writeUTF(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the output in the selected file
     */
    private static void automaticReadOutput() {
        try (InputStream fis = new FileInputStream("src/IOExamples/object.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            ArrayList<String> list = (ArrayList<String>) ois.readObject();
            System.out.println(list);
            System.out.println(ois.readDouble());
            System.out.println(ois.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
