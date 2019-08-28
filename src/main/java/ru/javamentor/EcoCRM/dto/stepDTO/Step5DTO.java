package ru.javamentor.EcoCRM.dto.stepDTO;

import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Step5DTO implements StepDTO {

    private Long id;

    private List<Task> tasks = new ArrayList<>();

    private Project project;

    public Step5DTO() {

    }

    public Step5DTO(Long id, List<Task> tasks, Project project) {
        this.id = id;
        this.tasks = tasks;
        this.project = project;
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
