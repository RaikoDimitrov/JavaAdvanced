package com.company.Generics.GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        GenericBox<String> genericBox = new GenericBox<>();
        for (int i = 0; i < n; i++) {
            genericBox.add(bufferedReader.readLine());
        }
      /*  int[] indexes = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        genericBox.swapElements(genericBox, indexes);
        System.out.println(genericBox);*/
        int elementsGreaterCount = genericBox.countGreaterThan(genericBox, bufferedReader.readLine());
        System.out.println(genericBox);
        System.out.println(elementsGreaterCount);
    }
}
