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
            this.cars.merge(car, 1, Integer::sum);
        }
    }

    public void sort(CAR_SORTING sorting) throws Exception {
        if (sorting == CAR_SORTING.BY_PRICE) {
            Map<Car, Integer> sortedCarMap = new TreeMap<>(
                    (o1, o2) -> o2.getPrice().compareTo(o1.getPrice())
            );
            sortedCarMap.putAll(this.cars);
            this.cars = sortedCarMap;

        } else if (sorting == CAR_SORTING.BY_AMOUNT) {
            List<Map.Entry<Car, Integer>> carList =
                    new LinkedList<Map.Entry<Car, Integer>>(this.cars.entrySet());
            carList.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
            this.cars = new HashMap<>();
            for (Map.Entry<Car, Integer> entry : carList) {
                this.cars.put(entry.getKey(), entry.getValue());
            }
        } else {
            throw new Exception("Ivalid sort type");
        }
    }

    public String toString() {
        StringBuilder info = new StringBuilder();
        for (Map.Entry<Car, Integer> entry : this.cars.entrySet()) {
            info.append(String.format("Машина %s в количестве %d%n", entry.getKey(), entry.getValue()))
        }
        return info.toString();
    }
}
