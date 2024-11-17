package com.company.FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split("\\s+");
        Consumer<String[]> textArr = array -> {
            for (String word : array) {
                System.out.println(word);
            }
        };
        textArr.accept(text);

    }
}
