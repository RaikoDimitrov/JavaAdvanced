package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        Function<Integer, Integer> add = num -> num + 1;
        Function<Integer, Integer> subtract = num -> num - 1;
        Function<Integer, Integer> multiply = num -> num * 2;
        Consumer<List<Integer>> print = list -> list.forEach(num -> System.out.print(num + " "));

        while (!input.equals("end")) {
            switch (input) {
                case "add" -> numbers = numbers.stream().map(add).collect(Collectors.toList());
                case "subtract" -> numbers = numbers.stream().map(subtract).collect(Collectors.toList());
                case "multiply" -> numbers = numbers.stream().map(multiply).collect(Collectors.toList());
                case "print" -> {
                    print.accept(numbers);
                    System.out.println();
                }
            }
            input = scanner.nextLine();
        }
    }
}
