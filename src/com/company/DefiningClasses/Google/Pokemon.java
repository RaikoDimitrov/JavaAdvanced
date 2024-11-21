package com.company.DefiningClasses.Google;

public class Pokemon {

    private final String name;
    private final String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getInfo() {
        return this.name + " " + this.type;
    }
}
