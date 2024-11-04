package com.company.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] parentheses = scanner.nextLine().toCharArray();
        boolean balanced = true;
        for (char c : parentheses) {
            if (c == '(' || c == '[' || c == '{')
            stack.push(c);
            else {
                if (stack.isEmpty()) {
                    //System.out.println("NO");
                    balanced = false;
                    break;
                }
                char top = stack.peek();
                if (c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{') stack.pop();
                else {
                    balanced = false;
                    //System.out.println("NO");
                }
            }
        }
        System.out.println(balanced ? "YES" : "NO");
        /*if (!balanced) System.out.println("NO");
        else System.out.println("YES");*/
    }
}
