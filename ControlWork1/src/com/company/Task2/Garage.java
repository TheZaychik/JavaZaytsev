package com.company.Task2;

import java.util.*;

public class Garage {
    private Integer maxCapacity;
    private Map<Car, Integer> cars;

    public Garage(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.cars = new HashMap<>();
    }

    public void addCar(Car... cars) {
        for (Car car : cars) {
            if (this.cars.size() < this.maxCapacity) {
                this.cars.merge(car, 1, Integer::sum);
            } else {
                System.out.println("Not enough space in garage");
            }
        }
    }

    public void sortPrint(CAR_SORTING sorting) {
        if (sorting == CAR_SORTING.BY_PRICE) {
            Map<Car, Integer> sortedCarMap = new TreeMap<>(
                    (o1, o2) -> o2.getPrice().compareTo(o1.getPrice())
            );
            sortedCarMap.putAll(this.cars);
            StringBuilder info = new StringBuilder();
            for (Map.Entry<Car, Integer> entry : sortedCarMap.entrySet()) {
                info.append(String.format("Машина %s в количестве %d%n", entry.getKey(), entry.getValue()));
            }
            System.out.println(info);

        } else if (sorting == CAR_SORTING.BY_AMOUNT) {
            List<Map.Entry<Car, Integer>> carList =
                    new LinkedList<>(this.cars.entrySet());
            carList.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
            StringBuilder info = new StringBuilder();
            for (Map.Entry<Car, Integer> entry : carList) {
                info.append(String.format("Машина %s в количестве %d%n", entry.getKey(), entry.getValue()));
            }
            System.out.println(info);
        } else {
            System.out.println("Invalid sort type");
        }
    }

    public String toString() {
        StringBuilder info = new StringBuilder();
        for (Map.Entry<Car, Integer> entry : this.cars.entrySet()) {
            info.append(String.format("Машина %s в количестве %d%n", entry.getKey(), entry.getValue()));
        }
        return info.toString();
    }
}
