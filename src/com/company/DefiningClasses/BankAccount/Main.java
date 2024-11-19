package com.company.DefiningClasses.BankAccount;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String command = input[0];
        Map<Integer, BankAccount> accountMap = new LinkedHashMap<>();
        while (!command.equals("End")) {
            String result = "";
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accountMap.put(bankAccount.getId(), bankAccount);
                    result = String.format("Account ID%d created", bankAccount.getId());
                    break;
                case "Deposit":
                    if (accountMap.containsKey(Integer.parseInt(input[1]))) {
                        accountMap.get(Integer.parseInt(input[1])).deposit(Double.parseDouble(input[2]));
                        result = String.format("Deposited %s to ID%s", input[2], input[1]);
                    } else {
                        result = "Account does not exist.";
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(input[1]));
                    break;
                case "GetInterest":
                    if (accountMap.containsKey(Integer.parseInt(input[1]))) {
                        double interestRate = accountMap.get(Integer.parseInt(input[1])).getInterestRate(Integer.parseInt(input[2]));
                        result = String.format("%.2f", interestRate);
                    } else {
                        result = "Account does not exist.";
                        break;
                    }

            }
            if (!result.isEmpty()) System.out.println(result);
            input = scanner.nextLine().split("\\s+");
            command = input[0];
        }
    }
}
