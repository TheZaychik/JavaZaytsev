package com.company;

import java.util.Date;

public class Task {
    public int id;
    public Date created;
    public Date completed;
    public String title;
    public String description;

    Task(int _id, String _title, String _description) {
        this.id = _id;
        this.created = new Date();
        this.completed = null;
        this.title = _title;
        this.description = _description;
    }

}
