package ru.javamentor.EcoCRM.model;

import ru.javamentor.EcoCRM.model.embedded.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @Enumerated(value = EnumType.STRING)
    private Status taskStatus = Status.TODO;

    @ManyToOne
    @JoinColumn(name = "step_id")
    private Step step;

    @OneToMany
    private List<Comment> comments;

    public TaskByStep() {

    }

    public TaskByStep(String description) {
        this.description = description;
    }

    public TaskByStep(String description, Step step) {
        this.description = description;
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

    public List<Comment> getComments() { return comments; }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
