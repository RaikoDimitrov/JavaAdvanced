package com.company.FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < peopleCount; i++) {
            String[] peopleInfo = scanner.nextLine().split(", ");
            people.put(peopleInfo[0], Integer.parseInt(peopleInfo[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiPredicate<Map.Entry<String, Integer>, Integer> younger = (person, limit) -> person.getValue() <= limit;
        BiPredicate<Map.Entry<String, Integer>, Integer> older = (person, limit) -> person.getValue() >= limit;

        Consumer<Map.Entry<String, Integer>> printName = person -> System.out.println(person.getKey());
        Consumer<Map.Entry<String, Integer>> printAge = person -> System.out.println(person.getValue());
        Consumer<Map.Entry<String, Integer>> printNameAndAge = person -> System.out.println(person.getKey()
                + " " + person.getValue());

        people.entrySet().stream()
                .filter(person -> condition.equals("younger")? younger.test(person, age) : older.test(person, age))
                .forEach(person -> {
                    if (format.equals("age")) printAge.accept(person);
                    else if (format.equals("name")) printName.accept(person);
                    else printNameAndAge.accept(person);
                });
    }
}
