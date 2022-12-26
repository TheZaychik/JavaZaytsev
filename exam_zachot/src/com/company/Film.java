package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Film {
    public String filmName;
    public ArrayList<Session> sessions;

    Film(String _filmName) {
        this.filmName = _filmName;
        this.sessions = new ArrayList<>();
    }

    public String toString() {
        return "Film: " + this.filmName + " | Sessions: " + this.sessions;
    }

    public void createSession(String _session, int _countPlaces, int _priceForTicket) {
        this.sessions.add(new Session(_session, _countPlaces, _priceForTicket));
    }

    public String priceForAllSessions() {
        int sum = 0;
        for (Session s : this.sessions){
            sum += s.getTotalSells();
        }
        return "Всего продано на сумму: " + sum;
    }

}
