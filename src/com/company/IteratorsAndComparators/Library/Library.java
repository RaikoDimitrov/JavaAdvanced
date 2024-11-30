package com.company.IteratorsAndComparators.Library;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Library implements Iterable<Book>{
    private final Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    @Override
    public void forEach(Consumer<? super Book> consumer) {
        for (Book book : books) {
            consumer.accept(book);
            System.out.println();
        }
    }

    private class LibIterator implements Iterator<Book> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            if (!hasNext()) throw new NoSuchElementException("No more books in the library.");
            /*Book currentBook = books[index];
            System.out.println(currentBook.getTitle() + " " + currentBook.getYear());
            index++;*/
            return books[index++];
        }
    }
}
