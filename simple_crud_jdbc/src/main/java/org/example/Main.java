package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        System.out.println("Admin Dashboard");

        Scanner input = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        while(true) {

            System.out.println("Welcome" );
            System.out.println("1.Add User to the database");
            System.out.println("2.Read all data in the database");
            System.out.println("3.Update the data");
            System.out.println("4.Delete the data");
            System.out.println("5.Exit");
            System.out.print("Choose a number ");
            int choice = input.nextInt();
            System.out.println("===============");


            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Adding a new user");
                    dao.addEmployee();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Reading all data in the database");
                    System.out.println();
                    dao.displayAll();
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Updating the data");
                    dao.updateUser();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Deleting the data");
                    dao.deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

    }
}