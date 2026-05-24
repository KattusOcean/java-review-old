package main.java.com.myjavadb.controller;

import main.java.com.myjavadb.model.DriverDAO;

import java.sql.*;

public class DriverController {

    private final DriverDAO ddao = new DriverDAO();

    public void createDriver(int numDriver, String name, String surname) {
        try {
            ddao.insertDriver(numDriver, name, surname);
            System.out.println("[✔] Driver inserted correctly");
            System.out.println("------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("[✘] Couldn't introduce the new driver! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }

    public void deleteDriver(int numDriver) {
        try {
            ddao.deleteDriver(numDriver);
            System.out.println("[✔] Driver deleted correctly");
            System.out.println("------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("[✘] Couldn't delete the driver! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }

    public void searchDriverByNum(int numDriver) {
        try {
            ddao.showDriverByNumDriver(numDriver);
            System.out.println("------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("[✘] Couldn't find the driver! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }

    public void searchDriverByRegister(String register) {
        try {
            ddao.showDriverByBusRegister(register);
            System.out.println("------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("[✘] Couldn't find the driver! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }
}
