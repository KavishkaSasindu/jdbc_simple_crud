package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        System.out.println("Hello, World!");

        Scanner input = new Scanner(System.in);



        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployee();


    }
}