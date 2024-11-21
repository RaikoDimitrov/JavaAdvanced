package com.company.DefiningClasses.Google;

public class Car {
    private String model;
    private int horsePower;

    public Car(String model, int horsePower) {
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getInfo() {
        return String.format("%s %d", this.model, this.horsePower);
    }
}
