package com.company;

public class Main {

    public static void main(String[] args) {
        NewThread t = new NewThread("b");
        t.start();
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();
        MyRunnable r3 = new MyRunnable();
        r1.run();
        r2.run();
        r3.run();
    }
}
