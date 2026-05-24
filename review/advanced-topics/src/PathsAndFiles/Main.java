package PathsAndFiles;

import java.io.*;
import java.nio.file.*;

public class Main {
    static void main() {
//        fileMethod();
//        pathMethod();
        DataPathMethod();
    }

    private static void fileMethod() {
        try {
            File directory = new File("src/PathsAndFiles/Directories");
            File file = new File(directory, "file.txt");

            directory.mkdirs();
            file.createNewFile();

            File newDirectory = new File(directory, "DirectoryV2");
            newDirectory.mkdirs();

            System.out.println("Does the directory \"" + directory.getName() + "\" exists?: " + directory.exists());
            System.out.println("Does the file \"" + file.getName() + "\" exists?: " + file.exists());
            System.out.println("File bytes: " + file.length());
            System.out.println("Directories inside \"" + directory.getName() + "\"");

            for (String fileName : directory.list()) {
                if (newDirectory.isDirectory()) {
                    System.out.println("- " + fileName);
                }
            }

            // Deletes when it is its turn
            // newDirectory.delete();
            // Deletes when the program finishes
            // file.deleteOnExit();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void pathMethod() {
        try {
            // We don't use 'new' because Path is an interface, not a class
            Path directory = Paths.get("src", "PathsAndFiles/p_Directories");
            Path file = Paths.get(directory.toString(), "p_file.txt");

            Files.createDirectories(directory);
            Files.createFile(file);

            System.out.println("Does \"" + directory + "\" exists?: " + Files.exists(directory));
            System.out.println("Does \"" + directory.getFileName() + "\" exists?: " + Files.exists(file));
            System.out.println("\"" + directory.getFileName() + "\" is: " + Files.size(file) + " bytes");

            for (Path path : Files.newDirectoryStream(directory)) {
                if (Files.isRegularFile(path)) {
                    System.out.println(path);
                }
            }

            // Files.delete(file);
            // Files.delete(directory);

        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }

    private static void DataPathMethod() {

        try {
            Path directory = Paths.get("src", "IOExamples/DataOutputInputStream");
            Path file = Paths.get(directory.toString(), "Main.java");

            Files.createDirectories(directory);
            Files.createFile(file);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
