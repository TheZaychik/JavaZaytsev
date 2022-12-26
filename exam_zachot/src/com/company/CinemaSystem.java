package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CinemaSystem {
    ArrayList<Film> films;
    Scanner sc;

    CinemaSystem() {
        this.sc = new Scanner(System.in);
        this.films = new ArrayList<>();
    }

    public void run() {
        while (true) {
            System.out.println("Кто вы?");
            System.out.println("1 - Администратор");
            System.out.println("2 - Пользователь");
            System.out.println("3 - Выход");
            switch (this.sc.nextLine()) {
                case "1" -> {
                    this.run_as_admin();
                }
                case "2" -> {
                    this.run_as_user();
                }
                case "3" -> {
                    return;
                }
                default -> {
                    System.out.println("Неверный ввод");
                }
            }
        }
    }

    public void printAllFilms() {
        System.out.println("Фильмы:");
        for (int i = 0; i < this.films.size(); i++) {
            System.out.println("ID: " + i + " " + this.films.get(i));
        }

    }

    public void printAllSessionsOnFilm(int film_index) {
        Film f = this.films.get(film_index);
        for (int i = 0; i < f.sessions.size(); i++) {
            System.out.println("Session ID:" + i + " " + f.sessions.get(i));
        }
    }

    public void run_as_admin() {
        while (true) {
            this.printAllFilms();
            System.out.println("Администратор. Выберите действие:");
            System.out.println("1 - Создать фильм");
            System.out.println("2 - Добавить сессию к фильму");
            System.out.println("3 - Выход");
            switch (this.sc.nextLine()) {
                case "1" -> {
                    this.createFilm();
                }
                case "2" -> {
                    System.out.println("Введите ID фильма:");
                    int id = this.sc.nextInt();
                    this.addSession(id);
                    System.out.println("Сессии на фильме:");
                    this.printAllSessionsOnFilm(id);
                }
                case "3" -> {
                    return;
                }
                default -> {
                    System.out.println("Неверный ввод!");
                }
            }
        }
    }

    public void createFilm() {
        System.out.println("Введите название фильма:");
        String filmName = this.sc.nextLine();
        this.films.add(new Film(filmName));
    }

    public void addSession(int film_index) {
        System.out.println("Введите сессию (формат 12:00 - 13:00):");
        String session = this.sc.nextLine();
        System.out.println("Введите кол-во мест:");
        int places = this.sc.nextInt();
        System.out.println("Введите цену за билет:");
        int price = this.sc.nextInt();
        Film f = this.films.get(film_index);
        f.createSession(session, places, price);
    }


    public void run_as_user() {
        while (true) {
            this.printAllFilms();
            System.out.println("Пользователь. Выберите действие:");
            System.out.println("1 - Купить билет на фильм");
            System.out.println("2 - Сумма проданных билетов на все сеансы по фильму");
            System.out.println("3 - Сумма проданных билетов на конкретный сеансы по фильму");
            System.out.println("4 - Выход");
            switch (this.sc.nextLine()) {
                case "1" -> {
                    this.buyTicketToFilm();
                }
                case "2" -> {
                    System.out.println("Введите ID фильма:");
                    int id = this.sc.nextInt();
                    Film f = this.films.get(id);
                    System.out.println(f.priceForAllSessions());
                }
                case "3" -> {
                    System.out.println("Введите ID фильма:");
                    int id = this.sc.nextInt();
                    Film f = this.films.get(id);
                    this.printAllSessionsOnFilm(id);
                    id = this.sc.nextInt();
                    Session s = f.sessions.get(id);
                    System.out.println("В сессии " + s + "всего продано на сумму: " + s.getTotalSells());

                }
                case "4" -> {
                    return;
                }
                default -> {
                    System.out.println("Неверный ввод");
                }
            }
        }
    }

    public void buyTicketToFilm() {
        System.out.println("Введите ID фильма:");
        int id = this.sc.nextInt();
        Film f = this.films.get(id);
        this.printAllSessionsOnFilm(id);
        System.out.println("Введите ID сессии:");
        id = this.sc.nextInt();
        Session s = f.sessions.get(id);
        s.buyPlaces();
    }

}
