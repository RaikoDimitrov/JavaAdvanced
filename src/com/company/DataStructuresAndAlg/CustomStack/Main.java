package com.company.DataStructuresAndAlg.CustomStack;

public class Main {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push(4);
        customStack.push(16);
        customStack.push(32);
        customStack.push(64);
        customStack.push(128);
        customStack.push(256);

        int element = customStack.pop();
        System.out.println("Removed last element: " + element);
        System.out.println(customStack);
        customStack.pop();
        int peek = customStack.peek();
        System.out.println("Peek element: " + peek);
        System.out.println(customStack);
        customStack.foreach(System.out::println);
    }
}
