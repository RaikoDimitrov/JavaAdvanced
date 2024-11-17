package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] intArray = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        /*Function<int[], Integer> minElement = array -> {
            int minElem = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < array[minElem]) {
                    minElem =  i;
                }
            }
            return minElem;
        };*/
        Function<Integer[], Integer> getMin = array -> Arrays.stream(array).min(Integer::compareTo).orElseThrow();
        System.out.println(getMin.apply(intArray));
        //System.out.println(intArray[minElement.apply(intArray)]);
    }
}
