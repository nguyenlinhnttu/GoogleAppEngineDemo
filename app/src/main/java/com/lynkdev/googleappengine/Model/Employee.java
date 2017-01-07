package com.lynkdev.googleappengine.Model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by LynkMieu on 1/2/2017.
 */

public class Employee {
    @SerializedName("id")
    Long id;
    @SerializedName("employeeCode")
    String employeeCode;
    @SerializedName("fullName")
    String fullName;
    @SerializedName("phoneNumber")
    private int phoneNumber;

    public Employee() {
    }
    public static Employee getEmployee (JSONObject jsonObject){
        return new Gson().fromJson(jsonObject.toString(),Employee.class);
    }

    public  static ArrayList<Employee> getListEmployee (JSONArray jsonArray) throws JSONException {
        ArrayList<Employee> arrayList = new ArrayList<>();
        for(int i = 0; i<jsonArray.length(); i++) {
            arrayList.add(getEmployee(jsonArray.getJSONObject(i)));
        }
        return arrayList;
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
