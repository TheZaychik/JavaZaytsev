package com.company;

import com.company.Task1.*;
import com.company.Task2.*;

import java.util.ArrayList;

public class Main {

    public static void Task1() {
        System.out.println("Задание 1");
        ArrayList<Reader> readers = new ArrayList<>();
        readers.add(new Reader("Иванов И.И", "ИТиАБД",
                "89168543782", "05-02-2000", 7642));
        readers.add(new Reader("Петров В.В", "МЭО",
                "89167321190", "07-09-2002", 4324));
        Reader r = readers.get(0);
        r.takeBook(3);
        r.takeBook("Гулливер", "Война и Мир", "Пираты", "Энциклопедия");
        r.takeBook(
                new Book("100 лет", "Автор А.Я"),
                new Book("Самоделкин", "Антоонов А.А")
        );
        r.returnBook(3);
        r.returnBook("Гулливер", "Война и Мир", "Пираты", "Энциклопедия");
        r.returnBook(
                new Book("100 лет", "Автор А.Я"),
                new Book("Самоделкин", "Антоонов А.А")
        );
    }

    public static void Task2() {
        System.out.println("Задание 2");

    }

    public static void main(String[] args) {
        Task1();
        Task2();
    }
}
