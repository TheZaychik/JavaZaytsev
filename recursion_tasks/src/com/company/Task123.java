package com.company;

import java.util.ArrayList;

public class Task123 {
    Integer[] mas;

    public static void Task1(int n) {
        Subtask1(n, 1);
    }

    private static void Subtask1(int n, int j) {
        if (j > n) {
            return;
        }
        System.out.println(j);
        Subtask1(n, j + 1);
    }

    public boolean Task2(int value) {
        return Subtask2(value, 0);
    }

    private boolean Subtask2(int value, int i) {
        if (this.mas[i] == value) {
            return true;
        }
        if (i + 1 == this.mas.length) {
            return false;
        }
        return this.Subtask2(value, i + 1);
    }

    public static double f(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double Task3(double a, double b, double fa, double fb, double eps) {
        double c = 0.5 * (a + b);
        if (Math.abs(a - b) < eps) return c;
        double fc = f(c);
        if (Math.abs(fc) < eps) return c;
        if (fc * fa < 0)
            return Task3(a, c, fa, fc, eps);
        else
            return Task3(c, b, fc, fb, eps);
    }
}
