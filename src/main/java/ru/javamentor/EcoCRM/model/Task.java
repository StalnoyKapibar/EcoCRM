package ru.javamentor.EcoCRM.model;

import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.TaskType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "task_status")
    @Enumerated(value = EnumType.STRING)
    private Status taskStatus = Status.TODO;

    @ManyToOne
    @JoinColumn(name = "step_id")
    private Step step;

    @OneToMany
    private List<Comment> comments;

    @Column(name = "task_type")
    @Enumerated(value = EnumType.STRING)
    private TaskType type;

    public Task() {

    }

    public Task(String description, Step step, TaskType taskType) {
        this.description = description;
        this.step = step;
        this.type = taskType;
    }

    public Task(String name, String description, Step step, TaskType taskType) {
        this.description = description;
        this.step = step;
        this.type = taskType;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType taskType) {
        this.type = taskType;
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
