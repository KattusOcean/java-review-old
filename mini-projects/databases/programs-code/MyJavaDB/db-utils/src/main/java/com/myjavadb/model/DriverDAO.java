package main.java.com.myjavadb.model;

import com.myjavadb.db.DriverManager;

import java.sql.*;

public class DriverDAO {

    /* ===== INSERT METHODS ===== */
    public void insertDriver(int numdriver, String name, String surname) throws SQLException {
        String sql = "INSERT INTO driver VALUES(?, ?, ?)";
        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numdriver);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.executeUpdate();
        }
    }

    /* ===== UPDATE METHODS ===== */

    /* ===== DELETE METHODS ===== */
    public void deleteDriver(int numDriver) throws SQLException {
        String sql = "DELETE FROM driver WHERE numdriver = ?";
        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numDriver);
            ps.executeUpdate();
        }
    }

    /* ===== SEARCH METHODS ===== */
    public void showDriverByNumDriver(int numDriver) throws SQLException {
        String sql = "SELECT * FROM driver WHERE numdriver = ?";
        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numDriver);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int num = rs.getInt("numdriver");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    System.out.printf("NumDriver: %d | Name: %s | Surname: %s%n", num, name, surname);
                }
            }
        }
    }

    public void showDriverByBusRegister(String register) throws SQLException {
        String sql = """
                    SELECT d.*
                    FROM driver d
                    JOIN bdp ON d.numdriver = bdp.numdriver
                    JOIN bus b ON bdp.register = b.register
                    WHERE b.register LIKE ?
                    """;

        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, register);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int numDriver = rs.getInt("numdriver");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    System.out.printf("NumDriver: %d | Name: %s | Surname: %s%n", numDriver, name, surname);
                }
            }
        }
    }
}
