package ru.javamentor.EcoCRM.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "step")
public class Step implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private StepNumber stepNumber;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Status status = Status.TODO;

    @OneToMany
    private List<TaskByStep> tasks;

    private LocalDateTime startStep;

    private LocalDateTime endStep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StepNumber getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(StepNumber stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<TaskByStep> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskByStep> tasks) {
        this.tasks = tasks;
    }
}
