package com.company.IteratorsAndComparators.SuperMarket;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SuperMarket superMarket = new SuperMarket("Apple", "Banana", "Orange");
        for (String s : superMarket) {
            System.out.println(s);
        }
    }
}
