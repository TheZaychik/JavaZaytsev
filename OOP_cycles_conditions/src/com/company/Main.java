package com.company;

import com.company.Task1.*;
import com.company.Task2.Vector;
import com.company.Task3.*;
import com.company.Task5.Returner;


public class Main {

    public static void Task1() {
        Matrix obj1 = new Matrix(3, 5);
        Matrix obj2 = new Matrix(3, 5);
        System.out.println("Матрица А:");
        obj1.getvalue();
        System.out.println("\nМатрица B:");
        obj2.getvalue();

        System.out.println("\nТранспонированная матрца A:");
        Matrix transposed_obj1 = obj1.transpose();
        transposed_obj1.getvalue();
        System.out.println("\nТранспонированная матрца B:");
        Matrix transposed_obj2 = obj2.transpose();
        transposed_obj2.getvalue();

        double multiNumber = 4.2;
        System.out.println("\nУмножение матрицы А на число " + multiNumber);
        Matrix result = obj1.numberMultiplication(multiNumber);
        if (result != null)
            result.getvalue();

        MatrixExecutor executerObj = new MatrixExecutor(obj1, obj2);
        System.out.println("\nСумма:");
        result = executerObj.summ();
        if (result != null)
            result.getvalue();

        System.out.println("\nРазность:");
        result = executerObj.difference();
        if (result != null)
            result.getvalue();

        Matrix obj3 = new Matrix(2, 3);
        Matrix obj4 = new Matrix(3, 2);
        System.out.println("\nМатрица C:");
        obj3.getvalue();
        System.out.println("\nМатрица D:");
        obj4.getvalue();
        executerObj = new MatrixExecutor(obj3, obj4);
        System.out.println("\nПроизведение C*D:");
        result = executerObj.composition();
        if (result != null)
            result.getvalue();

        int N = 3;
        Matrix obj5 = new Matrix(2, 2);
        System.out.println("\nМатрица E:");
        obj5.getvalue();
        System.out.println("\nМатрица E в степени " + N);
        result = obj5.exponentiation(N);
        if (result != null)
            result.getvalue();
    }

    public static void Task2() {
        Vector[] vectors = Vector.generator(10);
        for (int i = 0; i < vectors.length; i++) {
            vectors[i].value();
        }

        Vector vector1 = new Vector(2, 5, 5);
        Vector vector2 = new Vector(10, 25, 2);
        System.out.println("\nВектор 1");
        vector1.value();
        System.out.println("\nВектор 2");
        vector2.value();

        System.out.println("\nДлина вектора 1: " + vector1.length());
        System.out.println("Длина вектора 2: " + vector2.length());
        System.out.println("Скалярное произведение вектора 1 и 2: " + vector1.DotProduct(vector2));
        System.out.println("Векторное произведение вектора 1 и 2:");
        vector1.CrossProduct(vector2).value();

        System.out.println("Угол между векторами 1 и 2: " + vector1.VectorCos(vector2));
        System.out.println("Сумма векторов 1 и 2");
        vector1.summ(vector2).value();
        System.out.println("Разность векторов 1 и 2");
        vector1.difference(vector2).value();
    }

    public static void Task3() {
        Box box = new Box();
        box.setVolume(100.5);

        Ball ball1 = new Ball();
        ball1.setVolume(33.5);


        System.out.println("\nОбъём коробки: " + box.getVolume());
        boolean result = box.add(ball1);
        System.out.println("Флаг добавления объекта: " + result);
        System.out.println("Объём коробки: " + box.getVolume());

        SolidOfRevolution obj = new SolidOfRevolution();
        obj.setVolume(435);
        System.out.println("\nОбъём коробки: " + box.getVolume());
        result = box.add(obj);
        System.out.println("Флаг добавления объекта: " + result);
        System.out.println("Объём коробки: " + box.getVolume());
    }

    public static void Task5() {
        int[] values = {1, 2, 3};
        int[] scales = {1, 2, 10};

        Returner returner = new Returner(values, scales);
        int returnValue = returner.getNumber();
        System.out.println("Возвращенное значение: " + returnValue);
    }

    public static void main(String[] args) {
        Task1();
        Task2();
        Task3();
        // Task 4 в пакете com.company.Task4
        Task5();


    }
}
