package com.company.DataStructuresAndAlg.DataStructures.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addFirst(5);
        doublyLinkedList.addFirst(15);
        doublyLinkedList.addFirst(25);
        doublyLinkedList.addFirst(35);
        doublyLinkedList.addFirst(45);
        Integer index = doublyLinkedList.get(4);
        System.out.println(index);
        doublyLinkedList.removeFirst();
        doublyLinkedList.removeLast();
        doublyLinkedList.forEach(integer -> System.out.print(integer + " "));
        System.out.println();
        Integer[] intArray = doublyLinkedList.toArray(new Integer[0]);
        for (Integer integer : intArray) {
            System.out.println(integer);
        }

    }
}
