package IOExamples.ObjectIO;

import java.io.Serializable;

/*
 * When an object implements Serializable, its attributes must not change
 * if a file was already created due to the way Java works. Java will read
 * the file and check if the attributes are the same, if they are not
 * (i.e. surname -> surnames) the program won't work
 */
public class Employee implements Serializable {
    private String name = "";
    private String surname = "";
    private int age = 0;

    public Employee(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
