package main.java.ru.javamentor.model;

import static main.java.ru.javamentor.model.TaskStatus.*;

public class Task {
    Long id;
    String name;
    String performer; // ответсвенный за таску
    TaskStatus taskStatus = TODO;
}
