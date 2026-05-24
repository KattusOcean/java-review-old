package module4Objects.exercises.agenda;

public class Agenda {

    private final Contact[] contacts;

    public Agenda() {
        this.contacts = new Contact[10];
    }

    public void addContact(Contact c) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                contacts[i] = c;
                break;
            }
        }
    }

    public void listContacts() {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                System.out.println("\n--- CONTACT Nº" + (i+1) + " ---");
                System.out.println(contacts[i].toString());
            }
        }
    }

    public void searchContact(String key) {
        for (Contact contact : contacts) {
            if (contact != null && ((key.equals(contact.getDni()) || key.equals(String.valueOf(contact.getNumber()))))) {
                    System.out.println(contact.toString());
            }
        }
    }

    public void removeContact(String key) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null && ((key.equals(contacts[i].getDni())) || key.equals(String.valueOf(contacts[i].getNumber())))) {
                System.out.println("--- REMOVING CONTACT Nº" + i + " ---\n" + contacts[i].toString());
                contacts[i] = null;
            }
        }
    }

    public boolean showAgendaStatus() {
        for (Contact contact : contacts) {
            if (contact == null) {
                return false;
            }
        }
        return true;
    }

    public boolean existsContact(Contact c) {
        for (Contact contact : contacts) {
            if (contact == c) {
                return true;
            }
        }
        return false;
    }

    public boolean existsDNI(String dni) {
        for (Contact contact : contacts) {
            if (contact != null && dni.equals(contact.getDni())) {
                    return true;
            }
        }
        return false;
    }

    public boolean existsNumber(int number) {
        for (Contact contact : contacts) {
            if (contact != null && number == contact.getNumber()) {
                    return true;
            }
        }
        return false;
    }
}
