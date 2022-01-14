package com.example.springbootcrudapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")//you can only write "@Table" and JPA will create the table with the class name
public class Employee {

    @Id
    @GeneratedValue//This is for generate the id automatically by jpa
    @Column(name="emp_id")
    private int empId;

    @Column(name = "first_name")//adding this above every attribute will rename the column name
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + empId +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", email=" + email +
                '}';
    }
}