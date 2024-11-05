package com.company.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        //print diagonals of square matrix
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        //read matrix
        for (int rows = 0; rows < n; rows++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[rows] = rowData;
        }
        //print first diagonal
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        //print second diagonal
        for (int col = 0; col < n; col++) {
            System.out.print(matrix[n - 1 - col][col] + " ");
        }
    }
}
