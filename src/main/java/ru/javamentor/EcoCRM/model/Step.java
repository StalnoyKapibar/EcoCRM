package ru.javamentor.EcoCRM.model;

import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "steps")
public class Step implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "step_number")
    private StepNumber stepNumber;

    @ManyToOne
    @Column(name = "project")
    private Project project;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Status status = Status.TODO;

    @Column(name = "start_step")
    private LocalDateTime startStep;

    @Column(name = "end_step")
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
