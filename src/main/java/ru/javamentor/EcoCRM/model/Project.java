package ru.javamentor.EcoCRM.model;

import ru.javamentor.EcoCRM.model.embedded.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.IN_PROGRESS;

    @OneToOne
    private Point point;

    @OneToMany
    private List<User> users;

    @OneToOne
    private ManagementCompany company;

    @OneToOne
    private Contractor contractor;

    @OneToOne
    private Report report;



    public Project() {

    }

    public Project(User manager, Petition petition, String title, Status status, Point point, ManagementCompany company, Contractor contractor, Report report) {
        this.manager = manager;
        this.petition = petition;
        this.title = title;
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(manager, project.manager) &&
                Objects.equals(petition, project.petition) &&
                Objects.equals(title, project.title) &&
                status == project.status &&
                Objects.equals(point, project.point) &&
                Objects.equals(company, project.company) &&
                Objects.equals(contractor, project.contractor) &&
                Objects.equals(report, project.report);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manager, petition, title, status, point, company, contractor, report);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
