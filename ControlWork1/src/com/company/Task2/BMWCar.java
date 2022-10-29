package com.company.Task2;

public class BMWCar extends Car {
    private String bmwModel;

    public BMWCar(String bmwModel, String color, String transmissionType, Integer maxSpeed, Integer price) {
        super(color, transmissionType, maxSpeed, price);
        this.bmwModel = bmwModel;
    }

    public void BMWBeep() {
        System.out.println("BMW Beep");
    }

    public String getBmwModel() {
        return bmwModel;
    }
    public String toString(){
        return String.format("BMW model %s", this.bmwModel);
    }
}
