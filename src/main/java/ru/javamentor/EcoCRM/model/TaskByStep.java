package ru.javamentor.EcoCRM.model;

import main.java.ru.javamentor.EcoCRM.model.TaskStatus;
import static main.java.ru.javamentor.EcoCRM.model.TaskStatus.*;

public class TaskByStep {
    Long id;
    String name;
    String performer; // ответсвенный за таску
    TaskStatus stepTask = TODO;
}
