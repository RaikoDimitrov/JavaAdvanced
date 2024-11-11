package com.company.SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> userFound = new TreeMap<>();

        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            String ip = data[0].split("=")[1];
            //String message = data[1].split("=")[1];
            String user = data[2].split("=")[1];

            if (!userFound.containsKey(user)) {
                userFound.put(user, new LinkedHashMap<>(){{put(ip, 1);}});
            } else {
                Map<String, Integer> currentIps = userFound.get(user);
                if (currentIps.containsKey(ip)) {
                    int ipCount = currentIps.get(ip);
                    currentIps.put(ip, ipCount + 1);
                } else currentIps.put(ip, 1);
            }

            input = scanner.nextLine();
        }
        //print
        userFound.forEach((user, value) -> {
            System.out.println(user + ":");
            StringBuilder result = new StringBuilder();
            for (Map.Entry<String, Integer> entry : value.entrySet()) {
                result.append(entry.getKey()).append("  => ").append(entry.getValue()).append(", ");
            }
            if (result.length() > 0) {
                result.setLength(result.length() - 2);
            }
            System.out.println(result + ".");
        });
    }
}
