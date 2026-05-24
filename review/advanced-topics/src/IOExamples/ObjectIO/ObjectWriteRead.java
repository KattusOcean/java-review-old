package IOExamples.ObjectIO;

import java.io.*;
import java.util.ArrayList;

public class ObjectWriteRead {
    static void main() {
        read_employee();
        write_employee();
    }

    /**
     * Writes inside the file the employees using an Arraylist (Object)
     */
    private static void write_employee() {
        // The object must implement Serializable
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Pep", "Ortiz", 29));
        employees.add(new Employee("Clauida", "Roldan", 38));
        employees.add(new Employee("Jordi", "Exposito", 23));
        employees.add(new Employee("Lucia", "Rivas", 53));

        // For binary files should be used ".set" (serialized), ".bin" (binary) or ".dat" (data file)
        try (OutputStream fos = new FileOutputStream("src/IOExamples/ObjectIO/ObjectOutputInputStream/employees.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(employees);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Shows the employees included in the file using an Arraylist (Object)
     */
    private static void read_employee () {
        // The object must implement Serializable
        ArrayList<Employee> employees = new ArrayList<>();

        // For binary files should be used ".set" (serialized), ".bin" (binary) or ".dat" (data file)
        try (InputStream fis = new FileInputStream("src/IOExamples/ObjectIO/ObjectOutputInputStream/employees.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            employees = (ArrayList<Employee>) ois.readObject();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Employee e : employees) {
            System.out.println(e);
        }

    }
}
