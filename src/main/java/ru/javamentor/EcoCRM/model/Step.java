package ru.javamentor.EcoCRM.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "step")
public class Step implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private StepNumber stepNumber;

    @ManyToOne
    private Project project;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Status status = Status.TODO;

    public Step() {

    }

    public Step(StepNumber stepNumber, String description, Status status, LocalDateTime startStep, LocalDateTime endStep) {
        this.stepNumber = stepNumber;
        this.description = description;
        this.status = status;
        this.startStep = startStep;
        this.endStep = endStep;
    }

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


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDateTime getStartStep() {
        return startStep;
    }

    public void setStartStep(LocalDateTime startStep) {
        this.startStep = startStep;
    }

    public LocalDateTime getEndStep() {
        return endStep;
    }

    public void setEndStep(LocalDateTime endStep) {
        this.endStep = endStep;
    }
}
