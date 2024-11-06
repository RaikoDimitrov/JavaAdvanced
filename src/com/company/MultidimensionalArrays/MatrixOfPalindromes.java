package com.company.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowCol = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[][] matrix = new String[rowCol[0]][rowCol[1]];
        char first = 'a';
        for (int i = 0; i < rowCol[0]; i++) {
            char second = first;
            for (int j = 0; j < rowCol[1]; j++) {
                matrix[i][j] = first + "" + second + "" + first;
                System.out.print(matrix[i][j] + " ");
                second += 1;
            }
            first += 1;
            System.out.println();
        }
    }
}
