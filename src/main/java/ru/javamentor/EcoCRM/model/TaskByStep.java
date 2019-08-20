package ru.javamentor.EcoCRM.model;

import ru.javamentor.EcoCRM.model.embedded.Status;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tasks")
public class TaskByStep implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "performer")
    private User performer; // ответсвенный за таску

    @Column(name = "task_status")
    private Status taskStatus = Status.TODO;

    @ManyToOne
    private Step step;

    public TaskByStep() {

    }

    public TaskByStep(String description, User performer, Step step) {
        this.description = description;
        this.performer = performer;
        this.step = step;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPerformer() {
        return performer;
    }

    public void setPerformer(User performer) {
        this.performer = performer;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }
}
