package com.company.Generics.GenericScale;

public class Scale<T extends Comparable<T>> {
    private final T right;
    private final T left;

    public Scale(T right, T left) {
        this.right = right;
        this.left = left;
    }
    public T getHeavier() {
        if (this.left.compareTo(this.right) == 0) {
            return null;
        } else if (this.right.compareTo(this.left) > 0) return this.right;
        return this.left;
    }
}
