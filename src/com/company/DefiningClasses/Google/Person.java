package com.company.DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private Company company;
    private Car car;
    private final List<Pokemon> pokemon;
    private final List<Parent> parents;
    private final List<Children> children;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }
    public void addCar(String model, int horsePower) {
        this.car = new Car(model, horsePower);
    }
    public void addCompany(String name, String department, double salary) {
        this.company = new Company(name, department, salary);
    }
    public void addPokemon(String name, String type) {
        pokemon.add(new Pokemon(name, type));
    }
    public void addParents(String name, String birthday) {
        parents.add(new Parent(name, birthday));
    }
    public void addChildren(String name, String birthday) {
        children.add(new Children(name, birthday));
    }

    public void printInfo() {
        System.out.println(this.name);
        System.out.println("Company:");
        if (this.company != null) System.out.println(this.company.getInfo());
        System.out.println("Car:");
        if (this.car != null) System.out.println(this.car.getInfo());
        System.out.println("Pokemon:");
        this.pokemon.forEach(e -> System.out.println(e.getInfo()));
        System.out.println("Parents:");
        this.parents.forEach(e -> System.out.println(e.getInfo()));
        System.out.println("Children:");
        this.children.forEach(e -> System.out.println(e.getInfo()));

    }
}
