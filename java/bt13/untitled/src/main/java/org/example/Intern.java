package org.example;

import java.util.Date;

public class Intern extends Employee {
    private String majors;
    private int semester;
    private String universityName;

    public Intern(String id, String fullName, Date birthDay, String phone, String email, int employeeType, String majors, int semester, String universityName) {
        super(id, fullName, birthDay, phone, email, employeeType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + " Intern{" +
                "majors='" + majors + '\'' +
                ", semester=" + semester +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}
