package com.company.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int numOfElem = Integer.parseInt(input[0]);
        int numOfElemToPop = Integer.parseInt(input[1]);
        int isPresent = Integer.parseInt(input[2]);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //add numbers to stack
        String[] elements = scanner.nextLine().split("\\s+");
        for (int i = 0; i < numOfElem && i < elements.length; i++) {
            String elem = elements[i];
            if (!elem.isEmpty()) {
                stack.push(Integer.parseInt(elem));
            }
        }
        //pop numbers from stack
        for (int i = 0; i < numOfElemToPop && !stack.isEmpty(); i++) {
            stack.pop();
        }
        //check if number is present in stack
        if (stack.contains(isPresent)) {
            System.out.println("True");
        } else {
            System.out.println(stack.isEmpty() ? "0" : Collections.min(stack));
        }
    }
}
