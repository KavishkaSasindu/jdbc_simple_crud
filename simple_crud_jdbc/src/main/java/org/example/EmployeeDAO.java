package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDAO {

    Scanner input = new Scanner(System.in);

    ConnectionClass connection = new ConnectionClass();

    Connection con;

    public EmployeeDAO() throws SQLException, ClassNotFoundException {
        con = connection.getConnection();
    }


    Employee employee = new Employee();

//    add Data to the db
    public void addEmployee() throws SQLException{



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

    // read values

    public void displayAll() throws SQLException {

        final String QUERY = "SELECT * FROM employee";

        PreparedStatement stmt = con.prepareStatement(QUERY);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {  //rs.next() ship to the nest row
            employee.setEmployeeid(rs.getInt("employeeid"));
            employee.setFirstname(rs.getString("firstname"));
            employee.setLastname(rs.getString("lastname"));
            employee.setEmail(rs.getString("email"));

            System.out.println(employee.getEmployeeid() + " " + employee.getFirstname() + " " + employee.getLastname() + " " + employee.getEmail());

        }

    }

//    update user
    public void updateUser() throws SQLException{
        System.out.print("Enter employee id: ");
        int employeeID = input.nextInt();
        input.nextLine();

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

        final String QUERY = "UPDATE employee SET firstname=?,lastname=?,email=? WHERE employeeid=?";

        PreparedStatement stmt = con.prepareStatement(QUERY);
        stmt.setString(1, employee.getFirstname());
        stmt.setString(2, employee.getLastname());
        stmt.setString(3, employee.getEmail());
        stmt.setInt(4, employeeID);

        int value = stmt.executeUpdate();
        if(value == 1) {
            System.out.println("Employee updated successfully");
        }else{
            System.out.println("Employee not updated successfully");
        }
    }

    public void deleteEmployee() throws SQLException{
        System.out.print("Enter employee id: ");
        int employeeID = input.nextInt();
        input.nextLine();
        System.out.println();

        final String QUERY = "DELETE FROM employee WHERE employeeid=?";
        PreparedStatement stmt = con.prepareStatement(QUERY);
        stmt.setInt(1, employeeID);
        int value = stmt.executeUpdate();
        if(value == 1) {
            System.out.println("Employee deleted successfully");
        }else {
            System.out.println("Employee not deleted successfully");
        }
    }
}
