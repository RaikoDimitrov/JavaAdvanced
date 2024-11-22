package com.company.DataStructuresAndAlg.DataStructures.SmartArray;

import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private static final int SHRINK_THRESHOLD = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        if (this.size + 1 >= this.capacity) {
            this.resize();
        }
        this.data[this.size++] = element;
    }

    public void add(int index, int element) {
        checkIndex(index);
        if (this.size + 1 >= this.capacity) this.resize();
        shiftRight(index);
        this.data[index] = element;
        this.size++;
    }

    public int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    public int remove(int index) {
        checkIndex(index);
        int element = this.data[index];
        shiftLeft(element);
        this.size--;
        if (this.size <= this.capacity / SHRINK_THRESHOLD) shrink();
        return element;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (data[i] == element) return true;
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size - 1; i++) {
            consumer.accept(this.data[i]);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index %d is out of bounds for length %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    private void resize() {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];
        for (int i = 0; i < this.data.length; i++) {
            copy[i] = this.data[i];
        }
        this.data = copy;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[size - 1] = 0;
    }
    private void shiftRight(int index) {
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

    }

    private void shrink() {
        this.capacity /= 2;
        int[] copy = new int[this.capacity];
        for (int i = 0; i < this.data.length; i++) {
            copy[i] = this.data[i];
        }
        this.data = copy;
    }
}
