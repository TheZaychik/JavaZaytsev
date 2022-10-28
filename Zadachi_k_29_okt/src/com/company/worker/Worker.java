package com.company.worker;

import java.io.Serializable;

public abstract class Worker implements Serializable {
    public Integer id;
    public String name;

    public Worker(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract Double getMonthPayment();

    public String toString() {
        return "ID:" + id + "|Name: " + name + "|Month payment: " + this.getMonthPayment() + "\n";
    }
}
