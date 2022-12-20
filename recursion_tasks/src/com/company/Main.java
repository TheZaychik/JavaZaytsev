package com.company;

public class Main {

    public static void main(String[] args) {
        Task123.Task1(10);
        Integer[] mas = {1, 2, 3, 4, 5, 6, 7, 8};
        Task123 t = new Task123();
        t.mas = mas;
        System.out.println(t.Task2(5));
        System.out.println(t.Task2(99));
        System.out.println(Task123.Task3(0.0, 10, Task123.f(0.0), Task123.f(10.0), 0.00000001));
    }
}
