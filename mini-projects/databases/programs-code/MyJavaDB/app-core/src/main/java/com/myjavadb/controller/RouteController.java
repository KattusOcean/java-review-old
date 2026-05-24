package main.java.com.myjavadb.controller;

import main.java.com.myjavadb.model.RouteDAO;

import java.sql.*;
import java.util.Scanner;

public class RouteController {

    private final RouteDAO rdao = new RouteDAO();

    public void createRoute(String register, int numDriver, int idPlace, String day_of_week) {
        try {
            rdao.insertRoute(register, numDriver, idPlace, day_of_week);
        } catch (SQLException e) {
            System.out.println("[x] Couldn't insert the new route! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }

    public void updateRoute() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("--- UPDATE DAY OF THE WEEK BY ---");
            System.out.println("1. Register ");
            System.out.println("2. Driver number ");
            System.out.println("3. ID Place ");
            System.out.print("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            RouteDAO.routeAttribute attribute;
            Object value;

            switch (option) {
                case 1 -> {
                    attribute = RouteDAO.routeAttribute.REGISTER;
                    System.out.print("Introduce the register: ");
                    value = sc.nextLine();
                }
                case 2 -> {
                    attribute = RouteDAO.routeAttribute.NUMDRIVER;
                    System.out.print("Introduce the driver number: ");
                    value = sc.nextInt();
                }
                case 3 -> {
                    attribute = RouteDAO.routeAttribute.IDPLACE;
                    System.out.print("Introduce the place ID: ");
                    value = sc.nextInt();
                }
                default -> throw new IllegalArgumentException("Introduce a valid option (1-3)!!");
            }

            System.out.print("Introduce the new day: ");
            String newDay = sc.nextLine();

            rdao.updateRouteDayOfWeek(newDay, attribute, value);
            System.out.println("[✔] Route updated correctly");
            System.out.println("------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("[✘] Couldn't update the route! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }

    public void deleteRoute() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("--- DELETE ROUTE BY ---");
            System.out.println("1. Register ");
            System.out.println("2. Driver number ");
            System.out.println("3. ID Place ");
            System.out.print("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            RouteDAO.routeAttribute attribute;
            Object value;

            switch (option) {
                case 1 -> {
                    attribute = RouteDAO.routeAttribute.REGISTER;
                    System.out.print("Introduce the register: ");
                    value = sc.nextLine();
                }
                case 2 -> {
                    attribute = RouteDAO.routeAttribute.NUMDRIVER;
                    System.out.print("Introduce the driver number: ");
                    value = sc.nextInt();
                }
                case 3 -> {
                    attribute = RouteDAO.routeAttribute.IDPLACE;
                    System.out.print("Introduce the place ID: ");
                    value = sc.nextInt();
                }
                default -> throw new IllegalArgumentException("Introduce a valid option (1-3)!");
            }

            rdao.deleteRoute(attribute, value);
            System.out.println("[✔] Route deleted correctly");
            System.out.println("------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("[✘] Couldn't delete the route! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }

    public void searchDayByCity(String city) {
        try {
            rdao.showDayOfTheWeekOfARouteByCity(city);
            System.out.println("------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("[✘] Couldn't find the day! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }
}
