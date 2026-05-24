package module4Objects.exercises.agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int option, number;
        String name, surname, address, dni, key;

        Agenda agenda = new Agenda();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add contact");
            System.out.println("2. List contacts");
            System.out.println("3. Search contact");
            System.out.println("4. Remove contact");
            System.out.println("5. Agenda status");
            System.out.println("0. Exit");

            System.out.print("Select an option: ");
            option = sc.nextInt();
            System.out.println("-------------------------------------------");
            sc.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Bye!");
                    return;

                case 1:
                    System.out.print("Introduce the name: ");
                    name = sc.nextLine();
                    System.out.print("Introduce the surname/s: ");
                    surname = sc.nextLine();
                    System.out.print("Introduce the dni: ");
                    dni = sc.nextLine();
                    System.out.print("Introduce the address: ");
                    address = sc.nextLine();
                    System.out.print("Introduce the number: ");
                    number = sc.nextInt();

                    Contact contact = new Contact(name, surname, dni, address, number);
                    if (!agenda.existsContact(contact) && !agenda.existsDNI(dni) && !agenda.existsNumber(number)) {
                        agenda.addContact(contact);
                    } else if (agenda.existsContact(contact)) {
                        System.out.println("- WARNING: This contact already exists!");
                    } else if (agenda.existsDNI(dni)) {
                        System.out.println("- WARNING: The DNI must be unique!");
                    } else if (agenda.existsNumber(number)) {
                        System.out.println("- WARNING: The number must be unique!");
                    }
                    break;

                case 2:
                    agenda.listContacts();
                    break;

                case 3:
                    System.out.print("Introduce DNI or number: ");
                    key = sc.nextLine();
                    agenda.searchContact(key);
                    break;

                case 4:
                    System.out.print("Introduce DNI or number: ");
                    key = sc.nextLine();
                    agenda.removeContact(key);

                case 5:
                    if(agenda.showAgendaStatus()) {
                        System.out.println("Agenda is full!");
                    } else if (!agenda.showAgendaStatus()) {
                        System.out.println("There is space available yet!");
                    }
            }
        }
    }
}
