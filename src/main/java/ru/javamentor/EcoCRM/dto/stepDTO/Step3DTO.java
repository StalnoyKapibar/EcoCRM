package ru.javamentor.EcoCRM.dto.stepDTO;

import ru.javamentor.EcoCRM.model.Contractor;
import ru.javamentor.EcoCRM.model.ManagementCompany;
import ru.javamentor.EcoCRM.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Step3DTO implements StepDTO {

    private List<Contractor> contractors = new ArrayList<>();

    private Long id;

    private List<Task> tasks = new ArrayList<>();

    public Step3DTO() {

    }

    public Step3DTO(List<Contractor> contractors, Long id, List<Task> tasks) {
        this.contractors = contractors;
        this.id = id;
        this.tasks = tasks;
    }

    public List<Contractor> getContractors() {
        return contractors;
    }

    public void setContractors(List<Contractor> contractors) {
        this.contractors = contractors;
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
