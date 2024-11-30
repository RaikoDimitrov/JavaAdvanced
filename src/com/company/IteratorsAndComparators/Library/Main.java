package com.company.IteratorsAndComparators.Library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2005, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1994);
        Book bookThree = new Book("Rich Dad Poor Dad", 1997, "Robert Kiyosaki", "Sharon Lechter");
        Book bookFour = new Book("The Documents in the Case", 1988, "George Orwell");

        Library library = new Library(bookOne, bookTwo, bookThree, bookFour);
        List<Book> booksList= new ArrayList<>();
        BookComparator bookComparator = new BookComparator();
        Iterator<Book> bookIterator = library.iterator();

        booksList.add(bookOne);
        booksList.add(bookTwo);
        booksList.add(bookThree);
        booksList.add(bookFour);

        //print with sorted comparator
        booksList.sort(bookComparator);
        for (Book book : booksList) {
            System.out.println(book.getTitle() + " " + book.getYear());
        }
        System.out.println();

        //print with consumer
        library.forEach(book -> System.out.print("Title: " + book.getTitle() + "\n"
                + "Year: " + book.getYear() + "\n"
                + "Authors: "+ book.getAuthors()));
        System.out.println();
        //comparable
        System.out.println(bookOne.compareTo(bookTwo));
        System.out.println();
        //comparator
        int compare = bookComparator.compare(bookTwo, bookFour);
        System.out.println(compare);
        System.out.println();
        for (Book book : library) {
            System.out.println(book.getTitle() + " " + book.getYear());
        }
        System.out.println();
        //iterator
        while (bookIterator.hasNext()) {
            System.out.println(bookIterator.next());
        }

    }
}
