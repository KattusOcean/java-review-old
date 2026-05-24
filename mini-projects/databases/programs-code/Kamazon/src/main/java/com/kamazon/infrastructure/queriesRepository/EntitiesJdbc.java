package main.java.com.kamazon.infrastructure.queriesRepository;

import main.java.com.kamazon.domain.entities.Product;
import main.java.com.kamazon.domain.entities.User;
import main.java.com.kamazon.infrastructure.databaseConnector.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntitiesJdbc implements EntitiesDao {

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (name, email, password, role, balance) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail().toLowerCase());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole().name());
            ps.setDouble(5, user.getBalance());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO products (name, price, category, stock, rating) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCategory().name());
            ps.setInt(4, product.getStock());
            ps.setDouble(5, product.getRating());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Integer getUserId(String email) {
        String sql = "SELECT id FROM users WHERE LOWER(email) = LOWER(?)";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email.toLowerCase());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    System.out.println("User not found for email: " + email);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}