package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        Function<String, Integer> parse = Integer::parseInt;
        Function<List<Integer>, Integer> sumArray = arr -> {
          int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            return sum;
        };

        List<Integer> intNumbers = Arrays.stream(input).map(parse).collect(Collectors.toList());
        Integer result = sumArray.apply(intNumbers);
        System.out.printf("Count: %s%nSum: %s%n", input.length, result);
       /* System.out.printf("Count: %s%nSum: %s%n", input.length,
                Arrays.stream(input).mapToInt(Integer::parseInt).sum());
    */
    }
}
