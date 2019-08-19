package ru.javamentor.EcoCRM.model;

import org.hibernate.annotations.Type;
import ru.javamentor.EcoCRM.model.embedded.Status;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User manager;

    @OneToOne
    private Petition petition;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "status")
    private Status status = Status.IN_PROGRESS;

    @Column(name = "photo")
    @Type(type = "image")
    private byte[] photo;

    @OneToOne
    private Point point;

    @OneToOne
    private ManagementCompany company;

    @OneToOne
    private Contractor contractor;

    @OneToOne
    private Report report;

    public Project(User manager, Petition petition, String title, Status status, byte[] photo, Point point, ManagementCompany company, Contractor contractor, Report report) {
        this.manager = manager;
        this.petition = petition;
        this.title = title;
        this.status = status;
        this.photo = photo;
        this.point = point;
        this.company = company;
        this.contractor = contractor;
        this.report = report;
    }

    public Project(User manager, Petition petition, String title) {
        this.manager = manager;
        this.petition = petition;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public ManagementCompany getCompany() {
        return company;
    }

    public void setCompany(ManagementCompany company) {
        this.company = company;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Petition getPetition() {
        return petition;
    }

    public void setPetition(Petition petition) {
        this.petition = petition;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
