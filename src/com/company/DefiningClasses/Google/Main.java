package com.company.DefiningClasses.Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> personMap = new LinkedHashMap<>();
        String data;
        while (!"End".equals(data = scanner.nextLine())) {
            String[] input = data.split("\\s+");
            personMap.putIfAbsent(input[0], new Person(input[0]));
            switch (input[1]) {
                case "company" -> personMap.get(input[0]).addCompany(input[2], input[3], Double.parseDouble(input[4]));
                case "car" -> personMap.get(input[0]).addCar(input[2], Integer.parseInt(input[3]));
                case "pokemon" -> personMap.get(input[0]).addPokemon(input[2], input[3]);
                case "parents" -> personMap.get(input[0]).addParents(input[2], input[3]);
                case "children" -> personMap.get(input[0]).addChildren(input[2], input[3]);
            }
        }
        personMap.get(scanner.nextLine()).printInfo();
    }
}
