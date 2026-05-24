package main.java.com.myjavadb.model;

import com.myjavadb.db.DriverManager;

import java.sql.*;

public class BusDAO {

    /* ===== INSERT METHODS ===== */
    public void insertBus(String register, String type, String license) throws SQLException {
        String sql = "INSERT INTO bus VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, register);
            ps.setString(2, type);
            ps.setString(3, license);
            ps.executeUpdate();
        }
    }

    /* ===== UPDATE METHODS ===== */

    /* ===== DELETE METHODS ===== */
    public void deleteBus(String register) throws SQLException {
        String sql = "DELETE FROM bus WHERE register = ?";
        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, register);
            ps.executeUpdate();
        }
    }

    /* ===== SEARCH METHODS ===== */

}
