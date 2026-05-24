package main.java.com.myjavadb.controller;

import main.java.com.myjavadb.model.BusDAO;

import java.sql.SQLException;

public class BusController {

    private final BusDAO bdao = new BusDAO();

    public void createBus(String register, String type, String license) {
        try {
            bdao.insertBus(register, type, license);
            System.out.println("[✔] Bus inserted correctly");
            System.out.println("------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("[✘] Couldn't insert the new bus! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }

    public void deleteBus(String register) {
        try {
            bdao.deleteBus(register);
            System.out.println("[✔] Bus deleted correctly");
            System.out.println("------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("[✘] Couldn't delete the bus! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }
}
