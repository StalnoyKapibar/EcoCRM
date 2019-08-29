package ru.javamentor.EcoCRM.dto.stepDTO;

import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.model.embedded.Status;

import java.util.ArrayList;
import java.util.List;

public class Step5DTO implements StepDTO {

    private Long id;

    private List<Task> tasks = new ArrayList<>();

    private Project project;

    private Status status;

    public Step5DTO() {

    }

    public Step5DTO(Long id, List<Task> tasks, Project project, Status status) {
        this.id = id;
        this.tasks = tasks;
        this.project = project;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
