package ru.javamentor.EcoCRM.dto;

import ru.javamentor.EcoCRM.model.Report;
import ru.javamentor.EcoCRM.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Step7DTO implements StepDTO{

    private Long id;

    private Report report;

    private List<Task> taskList = new ArrayList<>();

    public Step7DTO() {
    }

    public Step7DTO(Long id, List<Task> taskList, Report report) {
        this.id = id;
        this.report = report;
        this.taskList = taskList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
