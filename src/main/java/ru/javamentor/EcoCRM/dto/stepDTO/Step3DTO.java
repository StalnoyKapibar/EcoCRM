package ru.javamentor.EcoCRM.dto.stepDTO;

import ru.javamentor.EcoCRM.model.Contractor;
import ru.javamentor.EcoCRM.model.ManagementCompany;
import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.model.embedded.Status;

import java.util.ArrayList;
import java.util.List;

public class Step3DTO implements StepDTO {

    private List<Contractor> contractors = new ArrayList<>();

    private Long id;

    private List<Task> tasks = new ArrayList<>();

    private Status status;

    public Step3DTO() {

    }

    public Step3DTO(List<Contractor> contractors, Long id, List<Task> tasks, Status status) {
        this.contractors = contractors;
        this.id = id;
        this.tasks = tasks;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
