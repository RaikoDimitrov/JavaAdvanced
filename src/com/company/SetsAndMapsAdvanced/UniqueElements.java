package com.company.SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UniqueElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> element = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            element.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }
        element.forEach(el -> System.out.print(el + " "));
    }
}
