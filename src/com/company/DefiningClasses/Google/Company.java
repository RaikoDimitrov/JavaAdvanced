package com.company.DefiningClasses.Google;

public class Company {

    private final String name;
    private final String department;
    private final double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getInfo() {
        return String.format("%s %s %.2f", this.name, this.department, this.salary);
    }
}
