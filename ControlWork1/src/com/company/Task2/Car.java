package com.company.Task2;

import java.util.Objects;

public abstract class Car {
    private String model;
    private String color;
    private String transmissionType;
    private Integer maxSpeed;
    private Integer currentSpeed;
    private Integer price;
    private Boolean turnedOn;

    public Car(String model, String color, String transmissionType, Integer maxSpeed, Integer price) {
        this.model = model;
        this.color = color;
        this.transmissionType = transmissionType;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.currentSpeed = 0;
        this.turnedOn = false;

    }

    public void start() {
        this.turnedOn = true;
    }

    public void stop() {
        this.turnedOn = false;
        this.currentSpeed = 0;
    }

    public void accelerate(Integer speed) {
        this.currentSpeed += (this.currentSpeed + speed) < this.maxSpeed ? speed : 0;
    }

    public String getColor() {
        return this.color;
    }

    public String getTransmissionType() {
        return this.transmissionType;
    }

    public Integer getMaxSpeed() {
        return this.maxSpeed;
    }

    public Integer getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Boolean getTurnedOn() {
        return this.turnedOn;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            return Objects.equals(this.getModel(), ((Car) obj).getModel());
        } else
            return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((model == null) ? 0 : model.hashCode());
        return result;
    }
}
