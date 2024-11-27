package com.company.DataStructuresAndAlg.DataStructures.DoublyLinkedList;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList <T> {
    private class ListNode {
        private ListNode prev;
        private ListNode next;
        private final T element;

        private ListNode(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "" + this.element;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public void addFirst(T element) {
        ListNode newHead = new ListNode(element);
        if (this.size == 0) {
            this.head = this.tail = newHead;
        } else {
            newHead.next = this.head;
            this.head.prev = newHead;
            this.head = newHead;
        }
        this.size++;
    }
    public void addLast(T element) {
        ListNode newTail = new ListNode(element);
        if (this.size == 0) {
            this.head = this.tail = newTail;
        } else {
            newTail.prev = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }
        this.size++;
    }
    public T get(int index) {
        checkIndex(index);
        ListNode currentNode;
        if (index <= this.size / 2) {
            currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode.element;
    }
    public T removeFirst() {
        checkEmpty();
        ListNode firstNode = this.head;
        this.head = this.head.next;
        if (this.head == null) this.tail = null;
        else this.head.prev = null;
        size--;
        return  firstNode.element;

    }
    public T removeLast() {
        checkEmpty();
        ListNode lastNode = this.tail;
        this.tail = this.tail.prev;
        if (this.tail == null) this.head = null;
        else this.tail.next = null;
        size--;
        return lastNode.element;

    }
    //printer
    public Consumer<T> forEach(Consumer<T> consumer) {
        ListNode currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
        return consumer;
    }

    public T[] toArray(T[] arr) {
        if (arr.length < this.size) {
            @SuppressWarnings("unchecked")
            T[] array = (T[]) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), this.size);
            arr = array;
        }
        ListNode head = this.head;
        int counter = 0;
        while (head != null) {
            arr[counter++] = head.element;
            head = head.next;
        }
        return arr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index %d is not valid, size: %d ", index, this.size));
        }
    }
    private void checkEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("Collection is empty");
        }
    }

}
