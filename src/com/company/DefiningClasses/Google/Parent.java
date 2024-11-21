package com.company.DefiningClasses.Google;

public class Parent {
    private final String name;
    private final String birthday;

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getInfo() {
        return this.name + " " + this.birthday;
    }
}
