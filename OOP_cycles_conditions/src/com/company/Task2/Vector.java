package com.company.Task2;

import java.util.Random;

public class Vector {
    int x;
    int y;
    int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void value() {
        System.out.format("(%d, %d, %d)%n", x, y, z);
    }


    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }


    public double DotProduct(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }


    public Vector CrossProduct(Vector vector) {
        int newX = y * vector.z - z * vector.y;
        int newY = z * vector.x - x * vector.z;
        int newZ = x * vector.y - y * vector.x;
        return new Vector(newX, newY, newZ);
    }


    public double VectorCos(Vector vector) {

        double dotproduct = DotProduct(vector);

        double length1 = length();

        double length2 = vector.length();
        return dotproduct / (Math.abs(length2) * Math.abs(length1));
    }


    public Vector summ(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }


    public Vector difference(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }


    public static Vector[] generator(int N) {
        Vector vectorsArr[];
        vectorsArr = new Vector[N];
        for (int i = 0; i < N; i++) {
            Random rand = new Random();
            int randx = rand.nextInt(100);
            int randy = rand.nextInt(100);
            int randz = rand.nextInt(100);
            vectorsArr[i] = new Vector(randx, randy, randz);
        }

        return vectorsArr;
    }

}
