package com.company.Task2;

public class VAZCar extends Car {
    private Integer rust;

    public VAZCar(Integer rust, String color, String transmissionType, Integer maxSpeed, Integer price) {
        super(color, transmissionType, maxSpeed, price);
        this.rust = rust;
    }

    public void addRust(Integer rust) {
        this.rust += rust;
    }

    public Integer getRust() {
        return rust;
    }

    public String toString() {
        return String.format("VAZ car with rust on the body %d%%", this.rust);
    }
}
