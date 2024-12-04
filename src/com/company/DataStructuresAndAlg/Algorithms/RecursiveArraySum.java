package com.company.DataStructuresAndAlg.Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int result = sumRecursiveArr(inputArr, inputArr.length - 1);
        System.out.println(result);
    }

    private static int sumRecursiveArr(int[] arr, int index) {
        if (index == 0) return arr[index];
        return arr[index] + sumRecursiveArr(arr, --index);
    }
}
