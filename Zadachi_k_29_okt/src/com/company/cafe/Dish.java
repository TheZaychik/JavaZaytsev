package com.company.cafe;

import java.util.ArrayList;
import java.util.Arrays;

public class Dish {
    public String name;
    public Integer price;
    public String unit;
    public ArrayList<String> composition;

    public Dish(String name, Integer price, String unit, ArrayList<String> composition) {
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.composition = composition;
    }

    public String toString() {
        return "Dish " + this.name + "for price" + this.price +
                "\nComposition " + this.composition;
    }
}
