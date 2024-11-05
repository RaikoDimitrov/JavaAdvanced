package com.company.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read matrix1
        String[] matrix1Dimensions = scanner.nextLine().split("\\s+");
        int matrix1Rows = Integer.parseInt(matrix1Dimensions[0]);
        int matrix1Cols = Integer.parseInt(matrix1Dimensions[1]);
        int[][] matrix1 = new int[matrix1Rows][matrix1Cols];
        for (int i = 0; i < matrix1Rows; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            for (int j = 0; j < matrix1Cols; j++) {
                matrix1[i][j] = Integer.parseInt(row[j]);
            }
        }
        //read matrix2
        String[] matrix2Dimensions = scanner.nextLine().split("\\s+");
        int matrix2Rows = Integer.parseInt(matrix2Dimensions[0]);
        int matrix2Cols = Integer.parseInt(matrix2Dimensions[1]);
        int[][] matrix2 = new int[matrix2Rows][matrix2Cols];
        for (int i = 0; i < matrix2Rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix2[i] = row;
        }
        //check sizes
        if (matrix1Rows != matrix2Rows || matrix1Cols != matrix2Cols) {
            System.out.println("Not equal.");
        } else {
            for (int i = 0; i < matrix1Rows; i++) {
                for (int j = 0; j < matrix1Cols; j++) {
                    if (matrix1[i][j] != matrix2[i][j]) System.out.println("Not equal");
                }
            }
            System.out.println("Equal");
        }
    }
}
