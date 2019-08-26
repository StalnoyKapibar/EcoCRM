package ru.javamentor.EcoCRM.dto;

import ru.javamentor.EcoCRM.model.Contractor;
import ru.javamentor.EcoCRM.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Step3DTO implements StepDTO{

    private Long id;

    private List<Contractor> contractors = new ArrayList<>();

    private List<Task> tasks = new ArrayList<>();

    public Step3DTO() {

    }

    public Step3DTO(Long id, List<Contractor> contractors, List<Task> tasks) {
        this.id = id;
        this.contractors = contractors;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Contractor> getContractors() {
        return contractors;
    }

    public void setContractors(List<Contractor> contractors) {
        this.contractors = contractors;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
