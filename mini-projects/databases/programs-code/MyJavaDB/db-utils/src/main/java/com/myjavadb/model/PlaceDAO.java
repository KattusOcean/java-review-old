package main.java.com.myjavadb.model;

import com.myjavadb.db.DriverManager;

import java.sql.*;

public class PlaceDAO {

    /* ===== INSERT METHODS ===== */
    public void insertPlace(int idPlace, String cp, String city, String site) throws SQLException {
        String sql = "INSERT INTO place VALUES(?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPlace);
            ps.setString(2, cp);
            ps.setString(3, city);
            ps.setString(4, site);
            ps.executeUpdate();
        }
    }

    /* ===== UPDATE METHODS ===== */

    /* ===== DELETE METHODS ===== */
    public void deletePlace(int idPlace) throws SQLException {
        String sql = "DELETE FROM place WHERE idplace = ?";
        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPlace);
            ps.executeUpdate();
        }
    }

    /* ===== SEARCH METHODS ===== */

}
