package ru.javamentor.EcoCRM.dto.stepDTO;

import ru.javamentor.EcoCRM.model.ManagementCompany;
import ru.javamentor.EcoCRM.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Step2DTO implements StepDTO{

    private ManagementCompany company;

    private Long id;

    private List<Task> tasks = new ArrayList<>();

    public Step2DTO() {

    }

    public Step2DTO(ManagementCompany company, Long id, List<Task> tasks) {
        this.company = company;
        this.id = id;
        this.tasks = tasks;
    }

    public ManagementCompany getCompany() {
        return company;
    }

    public void setCompany(ManagementCompany company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
