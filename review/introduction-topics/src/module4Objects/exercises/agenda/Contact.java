package module4Objects.exercises.agenda;

public class Contact {
    private String name = null;
    private String surnames = null;
    private String dni = null;
    private String address = null;
    private int number = 0;

    public Contact() {

    }

    public Contact(String name, String surnames, String dni, String address, int number) {
        this.name = name;
        this.surnames = surnames;
        this.dni = dni;
        this.address = address;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "+ Name: " + name + '\n' +
                "+ Surname(s): " + surnames + '\n' +
                "+ DNI: " + dni + '\n' +
                "+ Address: " + address + '\n' +
                "+ Number: " + number;
    }
}
