package com.company.Generics.ArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings("ALL")
public class ArrayCreator {
    public static <T> T[] create(int length, T item) {
        T[] arr = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            arr[i] = item;
        }
        return arr;
    }
    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] arr = (T[]) Array.newInstance(tClass, length);
        Arrays.fill(arr, item);
        return arr;
    }
}
