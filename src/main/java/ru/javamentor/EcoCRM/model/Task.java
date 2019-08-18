package main.java.ru.javamentor.EcoCRM.model;

import static main.java.ru.javamentor.EcoCRM.model.TaskStatus.*;

public class Task {
    Long id;
    String name;
    String performer; // ответсвенный за таску
    TaskStatus taskStatus = TODO;
}
