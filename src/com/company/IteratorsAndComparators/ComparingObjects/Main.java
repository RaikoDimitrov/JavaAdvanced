package com.company.IteratorsAndComparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> personList = new ArrayList<>();

        while (!input.equals("END")) {
            String[] personInfo = input.split("\\s+");
            personList.add(new Person(personInfo[0], Integer.parseInt(personInfo[1]), personInfo[2]));
            input = scanner.nextLine();
        }
        Person person = personList.get(Integer.parseInt(scanner.nextLine()) - 1);
        int count = (int) personList.stream().filter(person1 -> person1.compareTo(person) == 0).count();

        if (count == 1) System.out.println("No matches");
        else System.out.printf("%d %d %d%n", count, personList.size() - count, personList.size());
    }
}
