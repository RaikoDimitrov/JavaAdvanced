package com.company.SetsAndMapsAdvanced;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String playerName = input.split(":\\s+")[0];
            String cards = input.split(":\\s+")[1];
            String[] cardsArr = cards.split(",\\s+");

            if (!players.containsKey(playerName)) {
                players.put(playerName, new LinkedHashSet<>());
                players.get(playerName).addAll(Arrays.asList(cardsArr));
            } else {
                players.get(playerName).addAll(Arrays.asList(cardsArr));
            }

            input = scanner.nextLine();
        }

        players.entrySet().forEach(entry -> {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = calculatePoints(cards);
            System.out.printf("%s: %d%n", name, points);
        });
    }

    private static int calculatePoints(Set<String> cards) {
        int points = 0;
        Map<Character, Integer> values = new LinkedHashMap<>();
        values.put('S', 4);
        values.put('H', 3);
        values.put('D', 2);
        values.put('C', 1);
        values.put('J', 11);
        values.put('Q', 12);
        values.put('K', 13);
        values.put('A', 14);

        for (String card : cards) {
            if (Character.isDigit(card.charAt(0)) && !Character.isDigit(card.charAt(1))) {
                points += Integer.parseInt(String.valueOf(card.charAt(0))) * values.get(card.charAt(1));
            } else if (Character.isDigit(card.charAt(0)) && Character.isDigit(card.charAt(1))) {
                points += Integer.parseInt(String.valueOf(card.charAt(0)) + card.charAt(1)) * values.get(card.charAt(2));
            } else {
                points += values.get(card.charAt(0)) * values.get(card.charAt(1));
            }
        }
        return points;
    }
}
