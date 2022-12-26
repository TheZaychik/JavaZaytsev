package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Session {
    public String session;
    public Boolean[] places;
    // False - свободно, True - занято
    public int priceForTicket;
    Scanner sc;


    Session(String _session, int _countPlaces, int _priceForTicket) {
        this.session = _session;
        this.places = new Boolean[_countPlaces];
        Arrays.fill(places, false);
        this.priceForTicket = _priceForTicket;
        this.sc = new Scanner(System.in);
    }

    public void buyPlaces() {
        while (true) {
            System.out.println("False - свободно, True - занято");
            for (int i = 0; i < this.places.length; i++) {
                System.out.println("Свободные места");
                if (!this.places[i]) {
                    System.out.println("Место " + i);
                }
            }
            System.out.println("Выберите место для покупки (для выхода введите -1)");
            int id = this.sc.nextInt();
            if (id == -1) {
                return;
            }
            this.places[id] = true;
            System.out.println("Вы купили место " + id + " С вас " + this.priceForTicket);
        }
    }

    public int getTotalSells() {
        int count = 0;
        for (Boolean b : this.places) {
            if (b) {
                count++;
            }
        }
        return count * this.priceForTicket;
    }

    public String toString() {
        return this.session;
    }
}
