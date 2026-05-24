package main.java.com.kattus.app.infrastructure.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();

        // Read the "config.properties" file
        try(InputStream in = DbConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(in);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        String url = properties.getProperty("db.url");
        String name = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, name, password);
    }
}
