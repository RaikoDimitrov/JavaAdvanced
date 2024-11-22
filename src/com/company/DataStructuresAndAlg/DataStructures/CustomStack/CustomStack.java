package com.company.DataStructuresAndAlg.DataStructures.CustomStack;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private final static int INITIAL_CAPACITY = 4;
    private final static int INITIAL_SIZE = 0;
    private final static int SHRINK_THRESHOLD = 4;
    private int[] items;
    private int size;
    private int capacity;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[this.capacity];
        this.size = INITIAL_SIZE;
    }
    private void resize(int[] items) {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];
        for (int i = 0; i < this.items.length; i++) {
            copy[i] = this.items[i];
        }
        this.items = copy;
    }
    private void shrink(int[] items) {
        this.capacity /= 2;
        int[] copy = new int[this.capacity];
        for (int i = 0; i < this.items.length; i++) {
            copy[i] = items[i];
        }
        this.items = copy;
    }
    public int getSize() {
        return this.size;
    }
    public void push(int element) {
        if (this.size == this.capacity) resize(this.items);
        this.items[size++] = element;
    }
    public int pop() {
        checkEmpty();
        int element = this.items[this.size - 1];
        this.items[this.size - 1] = 0;
        this.size--;
        if (this.size <= this.capacity / SHRINK_THRESHOLD) shrink(this.items);
        return element;
    }
    public int peek() {
        checkEmpty();
        return this.items[this.size - 1];
    }

    private void checkEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("CustomStack is empty.");
        }
    }
    public Consumer<Integer> foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(items[i]);
        }
        return consumer;
    }

    @Override
    public String toString() {
        return "CustomStack - " +
                "items: " + Arrays.toString(items) +
                ", size: " + size +
                ", capacity: " + capacity;
    }
}
