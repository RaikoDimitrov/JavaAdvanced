package com.company.SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        Map<String, String> phoneBook = new LinkedHashMap<>();

        while (!data.equals("search")) {
            String name = data.split("-")[0];
            String phoneNumber = data.split("-")[1];
            phoneBook.put(name, phoneNumber);
            data = scanner.nextLine();
        }
        String name = scanner.nextLine();
        while (!data.equals("stop")) {
            if (phoneBook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phoneBook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
            name = scanner.nextLine();
        }
    }
}
