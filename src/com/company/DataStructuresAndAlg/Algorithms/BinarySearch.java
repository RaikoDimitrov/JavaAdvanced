package com.company.DataStructuresAndAlg.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int searchNum = Integer.parseInt(read.readLine());
        Arrays.sort(input);
        int result = binarySearch(input, 0, input.length - 1, searchNum);
        if (result == -1) System.out.println("Element not found");
        else System.out.println("Element found at index: " + result);
    }

    private static int binarySearch(int[] array, int start, int end, int searchNum) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (array[mid] == searchNum) return mid;
            if (array[mid] > searchNum) {
                return binarySearch(array, start, mid - 1, searchNum);
            }
            return binarySearch(array, mid + 1, end, searchNum);
        }
        return -1;
    }
}
