package com.company.MultidimensionalArrays;

import java.util.Scanner;

public class PositionOfElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixDimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixDimensions[0]);
        int cols = Integer.parseInt(matrixDimensions[1]);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        int element = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == element) {
                    found = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if (!found) System.out.println("Not found");
    }
}
