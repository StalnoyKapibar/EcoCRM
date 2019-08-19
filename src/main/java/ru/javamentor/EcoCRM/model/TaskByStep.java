package ru.javamentor.EcoCRM.model;


import static ru.javamentor.EcoCRM.model.TaskStatus.TODO;

public class TaskByStep {
    Long id;
    String name;
    String performer; // ответсвенный за таску
    TaskStatus stepTask = TODO;
}
