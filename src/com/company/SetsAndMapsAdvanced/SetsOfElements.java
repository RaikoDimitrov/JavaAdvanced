package com.company.SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] length = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> firstNums = new LinkedHashSet<>(length[0]);
        Set<Integer> secondNums = new LinkedHashSet<>(length[1]);

        for (int i = 0; i < length[0] + length[1]; i++) {
            if (i < length[0]) firstNums.add(Integer.parseInt(scanner.nextLine()));
            else secondNums.add(Integer.parseInt(scanner.nextLine()));
        }
        firstNums.retainAll(secondNums);
        System.out.println(firstNums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
