package com.company.IteratorsAndComparators.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return this.getTitle() + " (" + this.getYear() + ") by " + String.join(", ", this.getAuthors());
    }

    @Override
    public int compareTo(Book otherBook) {
        if (this.title.compareTo(otherBook.getTitle()) == 0) {
            return Integer.compare(this.getYear(), otherBook.getYear());
        }
        return this.title.compareTo(otherBook.getTitle());
    }
}
