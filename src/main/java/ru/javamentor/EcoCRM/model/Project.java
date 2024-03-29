package ru.javamentor.EcoCRM.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import ru.javamentor.EcoCRM.model.embedded.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
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

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.IN_PROGRESS;

    @OneToOne
    private Point point;

    @ManyToMany
    private List<User> users;

    @OneToOne
    private ManagementCompany company;

    @OneToOne
    private Contractor contractor;

    @OneToOne(cascade = {CascadeType.ALL})
    private Report report;

    @Column(name = "start_step")
    private LocalDate startStep;

    @Column(name = "end_step")
    private LocalDate endStep;

    @OneToMany
    private List<Photo> oldContainerPhoto;

    @OneToMany
    private List<Photo> newContainerPhoto;   //step 5

    //todo сделать поле для видео из step 5

    @Column(name="new_container_comment")
    private String newContainerComment; //step 5

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="new_container_date")
    private Date newContainerDate;  //step 5

    @OneToMany
    private List<CheckPoint> checkPoints;  //step 8

    public Project() {

    }

    public Project(User manager, Petition petition) {
        this.manager = manager;
        this.petition = petition;
    }

    public Project(User manager, Petition petition, Status status, Point point, ManagementCompany company, Contractor contractor, Report report) {
        this.manager = manager;
        this.petition = petition;
        this.status = status;
        this.point = point;
        this.company = company;
        this.contractor = contractor;
        this.report = report;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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

    public ManagementCompany getManagementCompany() {
        return company;
    }

    public void setManagementCompany(ManagementCompany company) {
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

    public LocalDate getStartStep() {
        return startStep;
    }

    public void setStartStep(LocalDate startStep) {
        this.startStep = startStep;
    }

    public LocalDate getEndStep() {
        return endStep;
    }

    public void setEndStep(LocalDate endStep) {
        this.endStep = endStep;
    }

    public List<Photo> getNewContainerPhoto() {
        return newContainerPhoto;
    }

    public void setNewContainerPhoto(List<Photo> newContainerPhoto) {
        this.newContainerPhoto = newContainerPhoto;
    }

    public String getNewContainerComment() {
        return newContainerComment;
    }

    public void setNewContainerComment(String newContainerComment) {
        this.newContainerComment = newContainerComment;
    }

    public Date getNewContainerDate() {
        return newContainerDate;
    }

    public void setNewContainerDate(Date newContainerDate) {
        this.newContainerDate = newContainerDate;
    }

    public List<CheckPoint> getCheckPoints() {
        return checkPoints;
    }
    public ManagementCompany getCompany() {
        return company;
    }

    public void setCompany(ManagementCompany company) {
        this.company = company;
    }

    public void setCheckPoints(List<CheckPoint> checkPoints) {
        this.checkPoints = checkPoints;
    }
    public List<Photo> getOldContainerPhoto() {
        return oldContainerPhoto;
    }

    public void setOldContainerPhoto(List<Photo> oldContainerPhoto) {
        this.oldContainerPhoto = oldContainerPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(manager, project.manager) &&
                Objects.equals(petition, project.petition) &&
                status == project.status &&
                Objects.equals(point, project.point) &&
                Objects.equals(company, project.company) &&
                Objects.equals(contractor, project.contractor) &&
                Objects.equals(report, project.report);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manager, petition, status, point, company, contractor, report);
    }
}
