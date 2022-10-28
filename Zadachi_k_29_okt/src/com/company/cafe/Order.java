package com.company.cafe;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Dish, Integer> dishes;
    private OrderStatus orderStatus;
    public String table;
    private Integer totalPrice;


    public Order(String table) {
        this.table = table;
        this.dishes = new HashMap<>();
        this.orderStatus = OrderStatus.PENDING;
        this.calcPrice();
    }

    private void calcPrice() {
        int sum = 0;
        for (Map.Entry<Dish, Integer> entry : this.dishes.entrySet()) {
            sum += entry.getKey().price * entry.getValue();
        }
        this.totalPrice = sum;
    }

    public void changeOrderStatus(OrderStatus status) {
        this.orderStatus = status;
    }

    public void addDishToOrder(Dish dish, Integer count) {
        this.dishes.put(dish, count);
    }


    public Integer getTotalPrice() {
        return this.totalPrice;
    }

    public Map<Dish, Integer> getDishes() {
        return this.dishes;
    }

    public String toString() {
        return "Order for " + this.table + " is " + this.orderStatus + "\nList: "
                + this.dishes + "\nTotal price: " + this.totalPrice;
    }
}
