package com.company.DataStructuresAndAlg.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SetCover {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] universe = Arrays.stream(reader.readLine().substring(10).split(", ")).mapToInt(Integer::parseInt).toArray();
        int numberOfSet = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        //fill list with sets
        for (int i = 0; i < numberOfSet; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }

        List<int[]> chosenSets = chooseSets(sets, universe);
        //print
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] chosenSet : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(chosenSet).replaceAll("[\\[\\]]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> selectedSets = new ArrayList<>();
        Set<Integer> universeSet = new HashSet<>();
        for (int element : universe) {
            universeSet.add(element);
        }
        while (!universeSet.isEmpty()) {
            int notChosenCount = 0;
            int[] chosenSet = sets.get(0);
            for (int[] set : sets) {
                int count = 0;
                for (int elem : set) {
                    if (universeSet.contains(elem)) count++;
                }
                //set with most elements
                if (notChosenCount < count) {
                    notChosenCount = count;
                    chosenSet = set;
                }
            }
            selectedSets.add(chosenSet);
            for (int elem : chosenSet) {
                universeSet.remove(elem);
            }
        }
        return selectedSets;
    }
}
