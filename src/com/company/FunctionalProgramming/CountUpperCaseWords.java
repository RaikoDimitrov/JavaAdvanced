package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split("\\s+");
        Predicate<String> startCapitalWord = word -> Character.isUpperCase(word.charAt(0));

        List<String> upperCaseWords = Arrays.stream(text)
                .filter(startCapitalWord)
                .collect(Collectors.toList());
        System.out.println(upperCaseWords.size());

        Consumer<String> print = System.out::println;
        upperCaseWords.forEach(print);
    }
}
