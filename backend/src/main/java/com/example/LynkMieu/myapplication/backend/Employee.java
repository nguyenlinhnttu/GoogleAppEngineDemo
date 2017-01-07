package com.example.LynkMieu.myapplication.backend;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by LynkMieu on 1/2/2017.
 */
@Entity
public class Employee {
    @Id
    Long id;
    @Index
    String employeeCode;
    String fullName;
    private int phoneNumber;

    public Employee() {
    }

    public Employee(Long id, String employeeCode, String fullName, int phoneNumber) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeCode='" + employeeCode + '\'' +
                ", fullName=" + fullName +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
