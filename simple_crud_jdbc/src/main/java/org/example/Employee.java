package org.example;

public class Employee {

    private int employeeid;
    private String firstname;
    private String lastname;
    private String email;

    public Employee() {
        System.out.println("Employee Constructor");
    }

    public Employee(int employeeid, String firstname, String lastname, String email) {
        this.employeeid = employeeid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
