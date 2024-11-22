package com.company.DataStructuresAndAlg.SmartArray;

public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();
        smartArray.add(4);
        smartArray.add(5);
        smartArray.add(6);
        smartArray.add(6);
        smartArray.add(6);
        System.out.println(smartArray);
        System.out.printf("Index: %d%n", smartArray.get(2));
        int removedElement = smartArray.remove(2);
        System.out.printf("Element removed: %d%n", removedElement);
        System.out.println(smartArray);
        smartArray.add(2, 15);
        System.out.println(smartArray);
        boolean contains = smartArray.contains(15);
        System.out.println(contains);
        smartArray.forEach(System.out::println);
    }
}
