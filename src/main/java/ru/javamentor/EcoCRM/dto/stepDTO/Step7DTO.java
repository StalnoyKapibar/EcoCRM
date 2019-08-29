package ru.javamentor.EcoCRM.dto.stepDTO;

import ru.javamentor.EcoCRM.model.Report;
import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.model.embedded.Status;

import java.util.ArrayList;
import java.util.List;

public class Step7DTO implements StepDTO {

    private Report report;

    private Long id;

    private List<Task> tasks = new ArrayList<>();

    private Status status;

    public Step7DTO() {

    }

    public Step7DTO(Report report, Long id, List<Task> tasks, Status status) {
        this.report = report;
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

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
