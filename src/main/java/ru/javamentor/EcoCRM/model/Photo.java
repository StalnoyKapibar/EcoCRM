package ru.javamentor.EcoCRM.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "photos")
public class Photo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    @Type(type = "image")
    private byte[] image;

    @ManyToOne
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
