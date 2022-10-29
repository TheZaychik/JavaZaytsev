package com.company.Task2;

public class BMWCar extends Car {

    public BMWCar(String model, String color, String transmissionType, Integer maxSpeed, Integer price) {
        super(model, color, transmissionType, maxSpeed, price);

    }

    public void BMWBeep() {
        System.out.println("BMW Beep");
    }

    public String toString() {
        return String.format("BMW model %s", this.model);
    }
}
