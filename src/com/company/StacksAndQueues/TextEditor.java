package com.company.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> textStack = new ArrayDeque<>();
        int countCommands = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        for (int i = 1; i <= countCommands; i++) {
            String[] commandParts = input.split("\\s+");
            int commandNumber = Integer.parseInt(commandParts[0]);
            switch (commandNumber) {
                case 1:
                    textStack.push(currentText.toString());
                    String text = commandParts[1];
                    currentText.append(text);
                    break;
                case 2:
                    textStack.push(currentText.toString());
                    int countEraser = Integer.parseInt(commandParts[1]);
                    int startIndex = currentText.length() - countEraser;
                    currentText.delete(startIndex, startIndex + countEraser);
                    break;
                case 3:
                    int index = Integer.parseInt(commandParts[1]);
                    System.out.println(currentText.charAt(index - 1));
                    break;
                case 4:
                    if (!textStack.isEmpty()) {
                        currentText = new StringBuilder(textStack.pop());
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
