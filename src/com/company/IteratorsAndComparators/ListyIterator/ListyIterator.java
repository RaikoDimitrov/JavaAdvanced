package com.company.IteratorsAndComparators.ListyIterator;

import java.util.List;
import java.util.NoSuchElementException;

public class ListyIterator {
    private final List<String> list;
    private int index;

    public ListyIterator(List<String> list) {
        this.list = list;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index + 1 < this.list.size();
    }

    public void print() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("Invalid Operation");
        }
        System.out.println(this.list.get(this.index));

    }
}
