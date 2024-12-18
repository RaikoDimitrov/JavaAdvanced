package com.company.DataStructuresAndAlg.Algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elements = scanner.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }
        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

        try {
            Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
            int totalCoins = usedCoins.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Number of coins to take: " + totalCoins);
            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
                System.out.println(usedCoin.getValue() + " coins(s) with value " + usedCoin.getKey());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        int currentSum = 0;
        int coinIndex = 0;
        List<Integer> sortedCoins = Arrays.stream(coins)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        Map<Integer, Integer> chosenCoins = new LinkedHashMap<>();

        while (currentSum != targetSum && coinIndex < sortedCoins.size()) {
            int currentCoin = sortedCoins.get(coinIndex);
            int remainder = targetSum - currentSum;
            int numberOfCoin = remainder / currentCoin;
            if (currentSum + currentCoin <= targetSum) {
                chosenCoins.put(currentCoin, numberOfCoin);
                currentSum += numberOfCoin * currentCoin;
            }
            coinIndex++;
        }
        if (currentSum != targetSum) throw new IllegalArgumentException("Error");
        return chosenCoins;
    }
}
