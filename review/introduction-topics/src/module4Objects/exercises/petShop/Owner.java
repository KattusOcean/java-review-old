package module4Objects.exercises.petShop;

public class Owner {
    private String name;
    private String surname;
    private String dni;

    public Owner(Shop shop) {
        this.name = assignOwnerName(shop);
        this.surname = assignOwnerSurname(shop);
        this.dni = assignOwnerDNI(shop);
    }

    public Owner(String name, String surname, String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Surname: " + surname + " | DNI: " + dni;
    }

    /*
    ========== METHODS TO GENERATE OWNERS ==========
     */
    public String assignOwnerName(Shop shop) {
        name = shop.createUniqueOwnerName();
        return name;
    }

    public String assignOwnerSurname(Shop shop) {
        surname = shop.createUniqueOwnerSurname();
        return surname;
    }

    public String assignOwnerDNI(Shop shop) {
        dni = shop.createUniqueDni();
        return dni;
    }
}
