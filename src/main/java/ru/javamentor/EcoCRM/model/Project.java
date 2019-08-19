package ru.javamentor.EcoCRM.model;

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

    @Column
    private String title;

    @Column
    private Status status;

    @OneToOne
    private Point point;

    @OneToOne
    private ManagementCompany company;

    @OneToOne
    private Contractor contractor;

    @OneToOne
    private Report report;


    public Project() {

    }

    public Project(String title, Status status, Point point, ManagementCompany company, Contractor contractor, Report report) {
        this.title = title;
        this.status = status;
        this.point = point;
        this.company = company;
        this.contractor = contractor;
        this.report = report;
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

}
