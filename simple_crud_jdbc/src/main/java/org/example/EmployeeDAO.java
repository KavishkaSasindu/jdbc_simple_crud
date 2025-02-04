package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDAO {

    Scanner input = new Scanner(System.in);

    ConnectionClass connection = new ConnectionClass();

    Connection con;

    public EmployeeDAO() throws SQLException, ClassNotFoundException {
        con = connection.getConnection();
    }

//    add Data to the db
    public void addEmployee() throws SQLException{


        Employee employee = new Employee();

        System.out.println();

        System.out.print("Enter employee id: ");
        int employeeId = input.nextInt();
        input.nextLine();
        employee.setEmployeeid(employeeId);

        System.out.println();

        System.out.print("Enter employee firstname: ");
        String firstname = input.nextLine();
        employee.setFirstname(firstname);

        System.out.println();

        System.out.print("Enter employee lastname: ");
        String lastname = input.nextLine();
        employee.setLastname(lastname);

        System.out.println();

        System.out.print("Enter employee email: ");
        String email = input.nextLine();
        employee.setEmail(email);

        System.out.println();


//        write sql query
        final String SQL = "INSERT INTO employee (employeeid,firstname,lastname,email) VALUES (?,?,?,?)";

//        create statement
        PreparedStatement stmt = con.prepareStatement(SQL);
//        after set values for query statement
        stmt.setInt(1,employee.getEmployeeid());
        stmt.setString(2, employee.getFirstname());
        stmt.setString(3, employee.getLastname());
        stmt.setString(4, employee.getEmail());
//          execute update
        int value = stmt.executeUpdate();

        if(value == 1) {
            System.out.println("Employee added successfully");
        }else{
            System.out.println("Employee not added successfully");
        }

        con.close();

    }
}
