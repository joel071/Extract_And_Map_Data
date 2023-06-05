package com.example.ExtractAndMapData.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    public String employeeId;
    public String firstName;
    private String lastName;
    private  String emailId;
    private String jou;
    private String department;
    private String tt;
    private String tous;


    public String getEmployeeId() {
        return employeeId;
    }
    

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    //public String getDepartment() {
        //return department;
    //}

    //public void setDepartment(String department) {
        //this.department = department;
    //}
   
}
