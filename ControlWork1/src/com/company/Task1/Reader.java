package com.company.Task1;

import java.util.Arrays;
import java.util.Date;

public class Reader {
    public String fullName;
    public String faculty;
    public String telNumber;
    public String dateOfBirth;
    public Integer readerID;

    public Reader(String fullName, String faculty, String telNumber, String dateOfBirth, Integer readerID) {
        this.fullName = fullName;
        this.faculty = faculty;
        this.telNumber = telNumber;
        this.dateOfBirth = dateOfBirth;
        this.readerID = readerID;
    }

    public void takeBook(Integer bookCount) {
        System.out.printf("%s взял %d книг(и)%n", this.fullName, bookCount);
    }

    public void takeBook(String... bookNames) {
        System.out.printf("%s взял книги: %s%n", this.fullName, Arrays.toString(bookNames));
    }

    public void takeBook(Book... books) {
        System.out.printf("%s взял книги: %s%n", this.fullName, Arrays.toString(books));
    }
    public void returnBook(Integer bookCount) {
        System.out.printf("%s вернул %d книг(и)%n", this.fullName, bookCount);
    }

    public void returnBook(String... bookNames) {
        System.out.printf("%s вернул книги: %s%n", this.fullName, Arrays.toString(bookNames));
    }

    public void returnBook(Book... books) {
        System.out.printf("%s вернул книги: %s%n", this.fullName, Arrays.toString(books));
    }
}
