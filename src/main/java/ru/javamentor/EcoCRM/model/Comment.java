package ru.javamentor.EcoCRM.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "task_by_step")
    private TaskByStep taskByStep;

    @Column(name = "time")
    private LocalDateTime time;

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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
