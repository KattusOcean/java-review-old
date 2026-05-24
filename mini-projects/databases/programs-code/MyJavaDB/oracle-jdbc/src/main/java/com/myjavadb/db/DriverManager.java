package com.myjavadb.db;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DriverManager {
    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();

        // Reads the "config.properties" file
        try (InputStream in = DriverManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(in);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        return java.sql.DriverManager.getConnection(url, user, password);
    }
}
