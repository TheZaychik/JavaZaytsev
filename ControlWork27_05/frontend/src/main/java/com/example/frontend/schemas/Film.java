package com.example.frontend.schemas;

public class Film {
    public Integer id;

    public String name;
    public String genre;
    public Integer duration;
    public Integer year;

    @Override
    public String toString() {
        return "ID: " + id.toString() + " Name: " + name;
    }
}
