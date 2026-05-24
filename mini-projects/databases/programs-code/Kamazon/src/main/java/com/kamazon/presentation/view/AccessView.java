package main.java.com.kamazon.presentation.view;

import java.util.Scanner;

public class AccessView {

    Scanner sc = new Scanner(System.in);

    public int accessStart() {
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.print("Select an option: ");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println("------------------------------------------");
        return option;
    }

    public String askEmail() {
        System.out.print("Email: ");
        return sc.nextLine();
    }

    public String askName() {
        System.out.print("Name: ");
        return sc.nextLine();
    }

    public String askPassword() {
        System.out.print("Password: ");
        return sc.nextLine();
    }

    public void successfulLogIn(String name) {
        System.out.println("Login successful. Welcome " + name + "!");
        System.out.println("------------------------------------------");
    }

    public void successfulRegister(String name) {
        System.out.println("Register successful. Welcome " + name + "!");
        System.out.println("------------------------------------------");
    }

    public void startLogIn() {
        System.out.println("=== LOG IN ===");
    }

    public void startRegistration() {
        System.out.println("=== REGISTRATION ===");
    }
}
