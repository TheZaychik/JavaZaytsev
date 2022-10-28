package com.company.cafe;

import java.util.*;

// Нет времени разрабатывать нормальные алгоритмы - время быстрокода
public class CafeOS {
    private final ArrayList<Dish> kitchenMenu;
    private final ArrayList<Dish> barMenu;
    private final Map<Dish, String> stopList;
    private final ArrayList<Order> orders;
    private final Scanner in;

    public CafeOS() {
        this.kitchenMenu = new ArrayList<>();
        this.barMenu = new ArrayList<>();
        this.stopList = new HashMap<>();
        this.orders = new ArrayList<>();
        this.in = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("-------------------------");
            System.out.println("CafeOS menu:");
            System.out.println("1) Create dish and add to menu");
            System.out.println("2) Delete dish from menu");
            System.out.println("3) Add dish to stop list");
            System.out.println("4) Delete dish from stop list");
            System.out.println("5) Create order");
            System.out.println("6) Change order status");
            System.out.println("7) Show all info");
            System.out.println("8) Exit");
            String input = in.nextLine();
            switch (input) {
                case "1" -> {
                    this.createDish();
                }
                case "2" -> {
                    this.deleteDish();
                }
                case "3" -> {
                    this.addDishToStopList();
                }
                case "4" -> {
                    this.removeDishFromStopList();
                }
                case "5" -> {
                    this.createOrder();
                }
                case "6" -> {
                    this.changeOrderStatus();
                }
                case "7" -> {
                    this.printAllInfo();
                }
                case "8" -> {
                    return;
                }
                default -> {
                    System.out.println("Wrong input, retry...");
                }
            }
        }

    }

    private void createDish() {
        String name, unit, partCompos;
        ArrayList<String> composition = new ArrayList<>();
        Integer price;
        System.out.println("-------------------------");
        System.out.println("Create Dish");
        System.out.println("Enter name of dish:");
        name = in.nextLine();
        System.out.println("Enter unit of dish:");
        unit = in.nextLine();
        System.out.println("Enter price of dish:");
        price = in.nextInt();
        while (true) {
            System.out.println("Enter composition of dish, for stop enter 0");
            partCompos = in.nextLine();
            if (Objects.equals(partCompos, "0")) break;
            composition.add(partCompos);
        }
        while (true) {
            String input = this.selectMenu();
            if (Objects.equals(input, "1")) {
                this.kitchenMenu.add(new Dish(name, price, unit, composition));
                break;
            } else if (Objects.equals(input, "2")) {
                this.barMenu.add(new Dish(name, price, unit, composition));
                break;
            } else if (Objects.equals(input, "3")) {
                break;
            } else {
                System.out.println("Wrong input, retry...");
            }

        }

    }

    private void deleteDish() {
        System.out.println("-------------------------");
        System.out.println("Delete Dish");
        while (true) {
            String input = this.selectMenu();
            if (Objects.equals(input, "1")) {
                System.out.println("Kitchen menu:");
                for (Dish d : this.kitchenMenu) {
                    System.out.println(this.kitchenMenu.indexOf(d) + ") " + d);
                }
                System.out.println("Input index of dish");
                this.kitchenMenu.remove(in.nextInt());
                break;
            } else if (Objects.equals(input, "2")) {
                System.out.println("Bar menu:");
                for (Dish d : this.barMenu) {
                    System.out.println(this.barMenu.indexOf(d) + ") " + d);
                }
                System.out.println("Input index of dish");
                this.barMenu.remove(in.nextInt());
                break;
            } else if (Objects.equals(input, "3")) {
                break;
            } else {
                System.out.println("Wrong input, retry...");
            }
        }
    }

    private void addDishToStopList() {
        System.out.println("-------------------------");
        System.out.println("Add dish to stop menu");
        while (true) {
            String input = this.selectMenu();
            if (Objects.equals(input, "1")) {
                System.out.println("Kitchen menu:");
                for (Dish d : this.kitchenMenu) {
                    System.out.println(this.kitchenMenu.indexOf(d) + ") " + d);
                }
                System.out.println("Input index of dish");
                Dish dish = this.kitchenMenu.get(in.nextInt());
                System.out.println("Input reason");
                this.stopList.put(dish, in.nextLine());
                break;
            } else if (Objects.equals(input, "2")) {
                System.out.println("Bar menu:");
                for (Dish d : this.barMenu) {
                    System.out.println(this.barMenu.indexOf(d) + ") " + d);
                }
                System.out.println("Input index of dish");
                Dish dish = this.barMenu.get(in.nextInt());
                System.out.println("Input reason");
                this.stopList.put(dish, in.nextLine());
                break;
            } else if (Objects.equals(input, "3")) {
                break;
            } else {
                System.out.println("Wrong input, retry...");
            }
        }
    }

    private void removeDishFromStopList() {
        System.out.println("-------------------------");
        System.out.println("Remove dish from stop menu");
        ArrayList<Dish> temp = new ArrayList<>();
        int i = 0;
        while (true) {
            for (Map.Entry<Dish, String> entry : this.stopList.entrySet()) {
                System.out.println(i + ") " + entry.getKey() + " for reason " + entry.getValue());
                temp.add(entry.getKey());
                i++;
            }
            System.out.println("Enter index of dish");
            this.stopList.remove(temp.get(in.nextInt()));
        }
    }

    private String selectMenu() {
        System.out.println("Which menu will be updated?");
        System.out.println("1) Kitchen");
        System.out.println("2) Bar");
        System.out.println("3) Exit");
        return in.nextLine();
    }

    private boolean dishInStopList(Dish dish) {
        for (Map.Entry<Dish, String> entry : this.stopList.entrySet()) {
            if (Objects.equals(entry.getKey().name, dish.name)) {
                return true;
            }
        }
        return false;
    }


    public void createOrder() {
        System.out.println("-------------------------");
        System.out.println("Create order");
        System.out.println("Enter table:");
        Order newOrder = new Order(in.nextLine());
        while (true) {
            String input = this.selectMenu();
            if (Objects.equals(input, "1")) {
                System.out.println("Kitchen menu:");
                for (Dish d : this.kitchenMenu) {
                    System.out.println(this.kitchenMenu.indexOf(d) + ") " + d);
                }
                System.out.println("Input index of dish");
                Dish dish = this.kitchenMenu.get(in.nextInt());
                if (this.dishInStopList(dish)) {
                    System.out.println("Dish in stop list");
                    break;
                }
                System.out.println("Input count of dish");
                newOrder.addDishToOrder(dish, in.nextInt());
            } else if (Objects.equals(input, "2")) {
                System.out.println("Bar menu:");
                for (Dish d : this.barMenu) {
                    System.out.println(this.barMenu.indexOf(d) + ") " + d);
                }
                System.out.println("Input index of dish");
                Dish dish = this.barMenu.get(in.nextInt());
                if (this.dishInStopList(dish)) {
                    System.out.println("Dish in stop list");
                    break;
                }
                System.out.println("Input count of dish");
                newOrder.addDishToOrder(dish, in.nextInt());
            } else if (Objects.equals(input, "3")) {
                break;
            } else {
                System.out.println("Wrong input, retry...");
            }
        }
    }

    public void changeOrderStatus() {
        System.out.println("-------------------------");
        System.out.println("Change order status");
        System.out.println("Select order");
        for (Order o: this.orders) {
            System.out.println(this.orders.indexOf(o) + ") " + o);
        }
        System.out.println("Input index of order");
        Order order = this.orders.get(in.nextInt());
        System.out.println("Select new status (1-4)");
        System.out.println(Arrays.toString(OrderStatus.values()));
        order.changeOrderStatus(OrderStatus.values()[in.nextInt()]);
    }
    public void printAllInfo() {
        System.out.println("All info");
        System.out.println("Orders:");
        for (Order o: this.orders) {
            System.out.println(this.orders.indexOf(o) + ") " + o);
        }
        System.out.println("Kitchen menu:");
        for (Dish d: this.kitchenMenu) {
            System.out.println(this.kitchenMenu.indexOf(d) + ") " + d);
        }
        System.out.println("Bar menu:");
        for (Dish d: this.barMenu) {
            System.out.println(this.barMenu.indexOf(d) + ") " + d);
        }
        System.out.println("Stop list:");
        for (Map.Entry<Dish, String> entry : this.stopList.entrySet()) {
            System.out.println(entry.getKey().name + "blocked for " + entry.getValue());

        }
    }
}
