package com.company.MultidimensionalArrays;

import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixDimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixDimensions[0]);
        int columns = Integer.parseInt(matrixDimensions[1]);
        int[][] matrix = new int[rows][columns];
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split(", ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
                sum = sum + matrix[i][j];
            }
        }
        //print matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Rows: " + rows);
        System.out.println("Columns: " + columns);
        System.out.println("Total sum: " + sum);
    }
}
