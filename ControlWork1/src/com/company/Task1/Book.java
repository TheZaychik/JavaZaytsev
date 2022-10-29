package com.company.Task1;

public class Book {
    public String bookName;
    public String author;

    public Book(String bookName, String author) {
        this.author = author;
        this.bookName = bookName;
    }
    public String toString() {
        return this.bookName;
    }
}
