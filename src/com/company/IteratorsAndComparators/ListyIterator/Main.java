package com.company.IteratorsAndComparators.ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(e -> !e.equals("Create"))
                .collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(data);
        String input = "";

        while (!input.equals("END")) {
            switch (input) {
                case "Move" -> System.out.println(listyIterator.move());
                case "Print" -> listyIterator.print();
                case "HasNext" -> System.out.println(listyIterator.hasNext());
            }
            input = scanner.nextLine();
        }
    }
}
