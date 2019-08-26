package ru.javamentor.EcoCRM.dto.stepDTO;

import ru.javamentor.EcoCRM.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Step6DTO implements StepDTO {

    private Long id;

    private List<Task> tasks = new ArrayList<>();

    public Step6DTO() {

    }

    public Step6DTO(Long id, List<Task> tasks) {
        this.id = id;
        this.tasks = tasks;
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
