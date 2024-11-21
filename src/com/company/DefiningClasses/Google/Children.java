package com.company.DefiningClasses.Google;

public class Children {
    private final String name;
    private final String birthday;

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getInfo() {
        return this.name + " " + this.birthday;
    }
}
