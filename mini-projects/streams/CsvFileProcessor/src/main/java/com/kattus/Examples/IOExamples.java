package com.kattus.Examples;

import java.io.*;

public class IOExamples {
    /* ============================================= INPUT / READ ============================================= */
    /* ===== FileInputStream ===== */
    public void fileInputStream() {
        try (FileInputStream fis = new FileInputStream("sample.csv")) {

            int letter;
            while((letter = fis.read()) != -1) {
                System.out.println(letter);
            }

        } catch (IOException e) {
            System.out.println("File or path does not exist: " + e.getMessage());
        }
    }

    /* ===== ObjectInputStream ===== */
    public void objectInputStream() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/com/kattus/Examples/OutputExamples/fileInputStreamExample.txt"))) {

            ois.readInt();
            ois.readLong();
            ois.readFloat();
            ois.readDouble();
            ois.readChar();
            ois.readUTF();
            ois.readBoolean();
            ois.readObject();

        } catch (IOException e) {
            System.out.println("File or path does not exist: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("Class does not exist: " + e.getMessage());
        }
    }

    /* ===== BufferedInputStream ===== */
    public void bufferedInputStream() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("sampleResults.csv"))) {

            int letter;
            while ((letter = bis.read()) != -1) {
                System.out.println(letter);
            }

        } catch (IOException e) {
            System.out.println("File or path does not exist: " + e.getMessage());
        }
    }

    /* ===== BufferedReader ===== */
    public void bufferedReader() {
        try(BufferedReader br = new BufferedReader(new FileReader("sample.csv"))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.print(line + "\n");;
            }

        } catch (IOException e) {
            System.out.println("File or path does not exist: " + e.getMessage());
        }
    }


    /* ============================================= OUTPUT / WRITE ============================================= */
    /* ===== FileOutputStream ===== */
    public void fileOutputStream() {
        try (FileOutputStream fos = new FileOutputStream("src/main/java/com/kattus/Examples/OutputExamples/fileOutputStreamExample.txt")) {

            int[] arr = {70, 105, 108, 101, 32, 79, 117, 116, 112, 117, 116, 32, 83, 116, 114, 101, 97, 109};
            for (int i : arr) {
                fos.write(i);
            }

        } catch (IOException e) {
            System.out.println("File or path does not exist: " + e.getMessage());
        }
    }

    /* ===== FileOutputStream ===== */
    public void objectOutputStream() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/com/kattus/Examples/OutputExamples/objectOutputStreamExample.txt"))) {

            oos.writeInt(12);
            oos.writeLong(144421L);
            oos.writeFloat(15.64f);
            oos.writeDouble(12.364134);
            oos.writeChar('f');
            oos.writeUTF("String");
            oos.writeBoolean(true);
            oos.writeObject(new Object());

        } catch (IOException e) {
            System.out.println("File or path does not exist: " + e.getMessage());
        }
    }

    /* ===== BufferedOutputStream ===== */
    public void bufferedOutputStream() {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/main/java/com/kattus/Examples/OutputExamples/bufferedOutputStreamExample.txt"))) {

            int[] arr = {66, 117, 102, 102, 101, 114, 101, 100, 32, 79, 117, 116, 112, 117, 116, 32, 83, 116, 114, 101, 97, 109};
            for (int i : arr) {
                bos.write(i);
            }

        } catch (IOException e) {
            System.out.println("File or path does not exist: " + e.getMessage());
        }
    }

    /* ===== BufferedReader ===== */
    public void bufferedWriter() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/kattus/Examples/OutputExamples/bufferedWriterExample.txt"))) {

            int[] arr = {66, 117, 102, 102, 101, 114, 101, 100, 32, 87, 114, 105, 116, 101, 114};
            for (int i : arr) {
                bw.write(i);
            }

            char[] charArr = {'B', 'u', 'f', 'f', 'e', 'r', 'e', 'd', ' ', 'W', 'r', 'i', 't', 'e', 'r'};
            for (char c : charArr) {
                bw.append(c);
            }

        } catch (IOException e) {
            System.out.println("File or path does not exist: " + e.getMessage());
        }
    }


    /* ============================================= BOTH ============================================= */
    public void bufferedReaderAndWriter() {
        try(BufferedReader br = new BufferedReader(new FileReader("sample.csv"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("sampleResults.csv"))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
            }

        } catch (IOException e) {
            System.out.println("File or path does not exist: " + e.getMessage());
        }
    }
}
