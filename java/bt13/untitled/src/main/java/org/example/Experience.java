package org.example;

import java.util.Date;

public class Experience extends Employee {
    private int expInYear;
    private String proSkill;

    public Experience(String id, String fullName, Date birthDay, String phone, String email, int employeeType, int expInYear, String proSkill) {
        super(id, fullName, birthDay, phone, email, employeeType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        System.out.println("Experience Employee: " + super.getFullName() + ", " + expInYear + " years of experience, ProSkill: " + proSkill);
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + " Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                '}';
    }
}
