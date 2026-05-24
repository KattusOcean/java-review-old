package main.java.com.myjavadb.controller;

import main.java.com.myjavadb.model.PlaceDAO;

import java.sql.SQLException;

public class PlaceController {

    private final PlaceDAO pdao = new PlaceDAO();

    public void createPlace (int idPlace, String cp, String city, String site) {
        try {
            pdao.insertPlace(idPlace, cp, city, site);
            System.out.println("[✔] Place inserted correctly");
            System.out.println("------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("[✘] Couldn't insert the new place! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }

    public void deletePlace(int idPlace) {
        try {
            pdao.deletePlace(idPlace);
            System.out.println("[✔] Place deleted correctly");
            System.out.println("------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("[✘] Couldn't delete the place! " + e.getMessage());
            System.out.println("------------------------------------------------------");
        }
    }
}
