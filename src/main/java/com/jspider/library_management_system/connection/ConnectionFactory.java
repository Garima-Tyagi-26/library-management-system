package com.jspider.library_management_system.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {

    public static Connection getConnectionFactory() throws SQLException {

        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        Properties properties = new Properties();

        try (InputStream input = ConnectionFactory.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (input == null) {
                throw new SQLException("db.properties file not found");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new SQLException("Unable to load database configuration", e);
        }

        String URL = properties.getProperty("db.url");
        String USER = properties.getProperty("db.user");
        String PASS = properties.getProperty("db.password");

        return DriverManager.getConnection(URL, USER, PASS);
    }
}