package com.company.Generics.ArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] stringArr = ArrayCreator.create(String.class, 5, "Asd");
        Integer[] integers = ArrayCreator.create(Integer.class,5, 4);
        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(stringArr));

    }
}
