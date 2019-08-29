package ru.javamentor.EcoCRM.dto.stepDTO;

import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.Photo;
import ru.javamentor.EcoCRM.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Step1DTO implements StepDTO {

    private Long id;

    private List<Task> tasks = new ArrayList<>();

    private Petition petition;

    private List<Photo> oldContainerPhotos;

    public Step1DTO() {

    }

    public Step1DTO(Long id, List<Task> tasks, Petition petition, List<Photo> oldContainerPhotos) {
        this.id = id;
        this.tasks = tasks;
        this.petition = petition;
        this.oldContainerPhotos = oldContainerPhotos;
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

    public Petition getPetition() {
        return petition;
    }

    public void setPetition(Petition petition) {
        this.petition = petition;
    }

    public List<Photo> getOldContainerPhotos() {
        return oldContainerPhotos;
    }

    public void setOldContainerPhotos(List<Photo> oldContainerPhotos) {
        this.oldContainerPhotos = oldContainerPhotos;
    }
}
