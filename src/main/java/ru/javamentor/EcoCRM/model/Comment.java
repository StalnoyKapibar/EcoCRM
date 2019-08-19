package ru.javamentor.EcoCRM.model;


import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    private TaskByStep taskByStep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TaskByStep getTaskByStep() {
        return taskByStep;
    }

    public void setTaskByStep(TaskByStep taskByStep) {
        this.taskByStep = taskByStep;
    }
}
