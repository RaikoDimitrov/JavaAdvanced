package com.company.MultidimensionalArrays;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandParts = input.split("\\s+");
            if (!validCommand(input, rows, cols)) {
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);
                String firstElem = matrix[row1][col1];
                String secondElem = matrix[row2][col2];
                matrix[row1][col1] = secondElem;
                matrix[row2][col2] = firstElem;
                printMatrix(matrix, rows, cols);
            }
            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean validCommand(String input, int rows, int cols) {
        String[] commandParts = input.split("\\s+");
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);
        if (commandParts.length != 5 || !commandParts[0].equals("swap")) return false;
        return row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows
                && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols;
    }
}
