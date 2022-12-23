package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Scheduler {
    ArrayList<Task> tasks;
    int id_counter;
    Scanner scanner;

    Scheduler() {
        this.tasks = new ArrayList<>();
        this.id_counter = 0;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Создать задание");
            System.out.println("2 - Удалить задание");
            System.out.println("3 - Отредактировать задание");
            System.out.println("4 - Просмотреть список ВСЕХ заданий");
            System.out.println("5 - Просмотреть детальную информацию о задании");
            System.out.println("6 - Просмотреть список ВЫПОЛНЕННЫХ заданий");
            System.out.println("7 - Просмотреть список НЕВЫПОЛНЕННЫХ заданий");
            System.out.println("8 - Просмотреть список ВСЕХ заданий по ДАТЕ");
            System.out.println("9 - Просмотреть список ВЫПОЛНЕННЫХ заданий по ДАТЕ");
            System.out.println("10 - Просмотреть список НЕВЫПОЛНЕННЫХ заданий по ДАТЕ");
            System.out.println("11 - Выполнить задание");
            System.out.println("12 - Выход");

            switch (this.scanner.nextLine()) {
                case "1": {
                    this.addTask();
                    break;
                }
                case "2": {
                    int task_id = this.readTaskId();
                    if (task_id != -1) {
                        this.deleteTask(task_id);
                    }
                    break;
                }
                case "3": {
                    int task_id = this.readTaskId();
                    if (task_id != -1) {
                        this.editTask(task_id);
                    }
                    break;
                }
                case "4": {
                    this.showAllTasks();
                    break;
                }
                case "5": {
                    int task_id = this.readTaskId();
                    if (task_id != -1) {
                        this.showTask(task_id);
                    }
                    break;
                }
                case "6": {
                    this.showCompletedTasks();
                    break;
                }
                case "7": {
                    this.showUncompletedTasks();
                    break;
                }
                case "8": {
                    Date date = this.readDate();
                    this.showAllTasks(date);
                    break;
                }
                case "9": {
                    Date date = this.readDate();
                    this.showCompletedTasks(date);
                    break;
                }
                case "10": {
                    Date date = this.readDate();
                    this.showUncompletedTasks(date);
                    break;
                }
                case "11": {
                    int task_id = this.readTaskId();
                    if (task_id != -1) {
                        this.completeTask(task_id);
                    }
                    break;
                }
                case "12": {
                    return;
                }
                default: {
                    System.out.println("Неверный ввод");
                    break;
                }
            }
        }
    }

    private Date readDate() {
        System.out.println("Введите дату в формате MMMM d, yyyy:");
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        String input = scanner.nextLine();
        try {
            return format.parse(input);
        } catch (ParseException pe) {
            System.out.println("Неверный ввод");
            return new Date();
        }
    }

    private int readTaskId() {
        System.out.println("Введите ID задания");
        try {
            return Integer.parseInt(this.scanner.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Неверный ввод");
        }
        return -1;
    }

    public void addTask() {
        System.out.println("Введите название задания:");
        String title = this.scanner.nextLine();
        System.out.println("Введите описание задания:");
        String description = this.scanner.nextLine();
        this.tasks.add(new Task(this.id_counter++, title, description));
        System.out.println("Задание добавлено");
    }

    private int getTaskIndexById(int task_id) {
        for (int i = 0; i < this.tasks.size(); i++) {
            if (Objects.equals(this.tasks.get(i).id, task_id)) {
                return i;
            }
        }
        return -1;
    }

    public void completeTask(int task_id) {
        int task_index = this.getTaskIndexById(task_id);
        this.tasks.get(task_index).completed = new Date();
    }

    public void editTask(int task_id) {
        Task t = this.tasks.get(this.getTaskIndexById(task_id));
        System.out.println("Что хотите изменить?");
        System.out.println("1 - Название");
        System.out.println("2 - Описание");
        switch (this.scanner.nextLine()) {
            case "1": {
                System.out.println("Введите новое название");
                t.title = this.scanner.nextLine();
            }
            case "2": {
                System.out.println("Введите новое описание");
                t.description = this.scanner.nextLine();
            }
            default: {
                System.out.println("Неверный ввод");
            }
        }
    }

    public void deleteTask(int task_id) {
        this.tasks.remove(this.getTaskIndexById(task_id));
    }

    public void showTask(int task_id) {
        Task t = this.tasks.get(this.getTaskIndexById(task_id));
        System.out.println("Название:");
        System.out.println(t.title);
        System.out.println("Описание:");
        System.out.println(t.description);
        System.out.println("Дата создания:");
        System.out.println(t.created);
        System.out.println("Дата выполнения:");
        if (t.completed != null) {
            System.out.println(t.completed);
        } else {
            System.out.println("Не выполнено");
        }
    }

    public void showAllTasks() {
        System.out.println("Все задания:");
        for (Task t : this.tasks) {
            System.out.println("ID: " + t.id + " Title: " + t.title);
        }
    }

    public void showCompletedTasks() {
        System.out.println("Выполненные задания:");
        for (Task t : this.tasks) {
            if (t.completed != null) {
                System.out.println("ID: " + t.id + " Title: " + t.title);
            }
        }
    }

    public void showUncompletedTasks() {
        System.out.println("Невыполненные задания:");
        for (Task t : this.tasks) {
            if (t.completed == null) {
                System.out.println("ID: " + t.id + " Title: " + t.title);
            }
        }
    }

    public void showAllTasks(Date date) {
        System.out.println("Все задания по дате " + date + ":");
        for (Task t : this.tasks) {
            if (t.created == date) {
                System.out.println("ID: " + t.id + " Title: " + t.title);
            }
        }
    }

    public void showCompletedTasks(Date date) {
        System.out.println("Выполненные задания по дате " + date + ":");
        for (Task t : this.tasks) {
            if (t.completed != null) {
                if (t.created == date) {
                    System.out.println("ID: " + t.id + " Title: " + t.title);
                }
            }
        }
    }

    public void showUncompletedTasks(Date date) {
        System.out.println("Невыполненные задания по дате " + date + ":");
        for (Task t : this.tasks) {
            if (t.completed == null) {
                if (t.created == date) {
                    System.out.println("ID: " + t.id + " Title: " + t.title);
                }
            }
        }
    }
}
