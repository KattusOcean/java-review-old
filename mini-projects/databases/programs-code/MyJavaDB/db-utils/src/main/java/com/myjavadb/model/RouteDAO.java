package main.java.com.myjavadb.model;

import com.myjavadb.db.DriverManager;
import oracle.jdbc.driver.VectorAccessor;

import java.sql.*;

public class RouteDAO {

    public enum routeAttribute {
        REGISTER,
        NUMDRIVER,
        IDPLACE
    }

    /* ===== INSERT METHODS ===== */
    public void insertRoute(String register, int numDriver, int idPlace, String dayOfWeek) throws SQLException {
        String sql = "INSERT INTO bdp VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, register);
            ps.setInt(2, numDriver);
            ps.setInt(3, idPlace);
            ps.setString(4, dayOfWeek);
            ps.executeUpdate();
        }
    }

    /* ===== UPDATE METHODS ===== */
    public void updateRouteDayOfWeek(String day_of_week, routeAttribute attribute, Object value) throws SQLException {
        String sql = switch (attribute) {
            case REGISTER -> "UPDATE bdp SET day_of_week = ? WHERE register = ?";
            case NUMDRIVER -> "UPDATE bdp SET day_of_week = ? WHERE numdriver = ?";
            case IDPLACE -> "UPDATE bdp SET day_of_week = ? WHERE idplace = ?";
        };

        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, day_of_week);
            switch (attribute) {
                case REGISTER -> ps.setString(2, (String) value);
                case NUMDRIVER, IDPLACE -> ps.setInt(2, (Integer) value);
            }
            ps.executeUpdate();
        }
    }

    /* ===== DELETE METHODS ===== */
    public void deleteRoute(routeAttribute attribute, Object value) throws SQLException {

        String sql = switch (attribute) {
            case REGISTER -> "DELETE FROM bdp WHERE register = ?";
            case NUMDRIVER -> "DELETE FROM bdp WHERE numdriver = ?";
            case IDPLACE -> "DELETE FROM bdp WHERE idplace = ?";
        };

        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            switch (attribute) {
                case REGISTER -> ps.setString(1, (String) value);
                case NUMDRIVER, IDPLACE -> ps.setInt(1, (Integer) value);
            }
            ps.executeUpdate();
        }
    }

    /* ===== SEARCH METHODS ===== */
    public void showDayOfTheWeekOfARouteByCity(String city) throws SQLException {
        String sql = """
                    SELECT day_of_week
                    FROM bdp
                    JOIN place p ON bdp.idplace = p.idplace
                    WHERE city LIKE ?
                    """;

        try (Connection conn = DriverManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, city);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String dayOfTheWeek = rs.getString("day_of_week");
                    System.out.printf("Day of the week: %s", dayOfTheWeek);
                }
                System.out.println();
            }
        }
    }
}
