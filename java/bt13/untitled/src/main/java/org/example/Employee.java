package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract class Employee {
    private String id;
    private String fullName;
    private Date birthDay;
    private String phone;
    private String email;
    private int employeeType;
    private static int employeeCount = 0;
    private List<Certificate> certificates;

    public Employee(String id, String fullName, Date birthDay, String phone, String email, int employeeType) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        this.certificates = new ArrayList<>();
        employeeCount++;
    }

    public abstract void showInfo();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void addCertificate(Certificate certificate) {
        this.certificates.add(certificate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDay=" + birthDay +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", employeeType=" + employeeType +
                ", certificates=" + certificates +
                '}';
    }
}
