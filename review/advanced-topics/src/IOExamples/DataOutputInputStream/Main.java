package IOExamples.DataOutputInputStream;

import java.io.*;

public class Main {
    static void main() {
        // `True` appends the data, if it is not written or is false the previous data will be deleted
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/IOExamples/DataOutputInputStream/data.dat", true));
             DataInputStream dis = new DataInputStream(new FileInputStream("src/IOExamples/DataOutputInputStream/data.dat"))) {

            // String will always be between 0 (min) and 10 (max) characters
            dos.writeUTF(String.format("%10s", "Manuel"));
            dos.writeInt(19);
            dos.writeDouble(193.50);
            dos.writeBoolean(true);

            // String will always be 10 exact characters long (possibly including blanks)
            dos.writeUTF(String.format("%-10.10s", "Lukas"));
            dos.writeInt(32);
            dos.writeDouble(521.35);
            dos.writeBoolean(false);

            dos.flush();
            dos.close();
            System.out.println("[+] Data backup done...\n");

            // String(.BYTES) = (2 + N) | Integer.BYTES = 4 | Double.BYTES = 8 | Boolean(.BYTES) = 1
            // `N` can be the exact lenght of every String or (when there is a lot of data) a "joker" for every String
            long jump = (2 + 10) + Integer.BYTES + Double.BYTES + 1;
            // This allow us to skip data (i.e. will skip "Manuel" and print "Lukas" directly)
            // dis.skip(jump);

            // Must be in write order
            int i = 0;
            while (dis.available() > 0) {
                System.out.println("--------- " + i + " ---------");
                System.out.println(dis.readUTF());
                System.out.println(dis.readInt());
                System.out.println(dis.readDouble());
                System.out.println(dis.readBoolean());
                i++;
            }

        } catch (IOException e) {
            System.out.println("[x] Failed data backup...");
            System.out.println(e.getMessage());
        }
    }
}