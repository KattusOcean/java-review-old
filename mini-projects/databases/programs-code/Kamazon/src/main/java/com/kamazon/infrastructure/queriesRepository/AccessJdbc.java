package main.java.com.kamazon.infrastructure.queriesRepository;

import main.java.com.kamazon.domain.entities.User;
import main.java.com.kamazon.domain.enums.UserRole;
import main.java.com.kamazon.domain.exceptions.PersistenceException;
import main.java.com.kamazon.infrastructure.databaseConnector.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessJdbc implements AccessDao {
    @Override
    public User logIn(String email, String password) {
        String sql = "SELECT * FROM users WHERE LOWER(email) = LOWER(?) AND password = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email.toLowerCase());
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {

                if (!rs.next()) return null;

                String roleStr = rs.getString("role");
                UserRole role = UserRole.valueOf(roleStr.toUpperCase());

                return new User (
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        role,
                        rs.getDouble("balance")
                );
            }
        } catch (SQLException e) {
            throw new PersistenceException("Could not find the user, try again", e);
        }
    }

    @Override
    public void register(String name, String email, String password) {
        EntitiesDao usersDao = new EntitiesJdbc();
        usersDao.addUser(new User(name, email, password, UserRole.CLIENT, 0.0));
    }
}
