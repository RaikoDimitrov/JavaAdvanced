package com.company.IteratorsAndComparators.SuperMarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SuperMarket implements Iterable<String> {
    private final List<String> fruits;

    public SuperMarket(String... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    @Override
    public Iterator<String> iterator() {
        return new ShopAssistant();
    }
    private class ShopAssistant implements Iterator<String> {
        int index = 0;
        @Override
        public boolean hasNext() {
            return index < fruits.size();
        }

        @Override
        public String next() {
            return fruits.get(index++);
        }
    }
}
