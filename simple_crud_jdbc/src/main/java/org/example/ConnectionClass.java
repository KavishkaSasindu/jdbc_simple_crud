package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    private final String URL = "jdbc:postgresql://localhost:5432/employeeDB";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "";

    Connection con;


    public ConnectionClass() throws SQLException,ClassNotFoundException {
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Class.forName("org.postgresql.Driver");

    }

    public Connection getConnection()  {
        return con;
    }
}
