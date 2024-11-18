package com.company.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Integer divideNum = Integer.parseInt(scanner.nextLine());
        Consumer<List<Integer>> reverse = list -> {
            List<Integer> reversedList = new ArrayList<>();
            for (int i = list.size() - 1; i >= 0; i--) {
                reversedList.add(list.get(i));
            }
            list.clear();
            list.addAll(reversedList);
        };
        Predicate<Integer> filterByNum = num -> num % divideNum != 0;
        UnaryOperator<List<Integer>> removedDivisibleNum = list -> list.stream()
                .filter(filterByNum).collect(Collectors.toList());
        reverse.accept(numbers);
        numbers = removedDivisibleNum.apply(numbers);
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
