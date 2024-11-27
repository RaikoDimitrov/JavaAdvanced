package com.company.Generics.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class GenericBox<T> {
    private final List<T> elements;

    public GenericBox() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public List<T> getElements() {
        return elements;
    }

    public void swapElements(GenericBox<T> box, int[] indexes) {
        List<T> elements = box.getElements();
        T elem = elements.get(indexes[0]);
        elements.set(indexes[0], elements.get(indexes[1]));
        elements.set(indexes[1], elem);
    }
    public <T extends Comparable<T>> int countGreaterThan(GenericBox<T> box,T compareParameter) {
        int count = 0;
        List<T> elements = box.getElements();
        for (T elem : elements) {
            if (elem.compareTo(compareParameter) > 0) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(element.getClass().getName()).append(": ").append(element).append("\n");
        }
        return sb.toString();
    }
}
