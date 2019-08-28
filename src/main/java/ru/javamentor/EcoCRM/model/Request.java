package ru.javamentor.EcoCRM.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "requests")
public class Request implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "personName")
    String personName;
    @Column(name = "projectName")
    String projectName;

    @Column(name = "personId")
    Long personId;

    @Column(name = "projectId")
    Long projectId;
    @Column(name = "managerId")
    Long managerId;
    public Request(){

    }

    public Request(String personName, String projectName, Long personId, Long projectId, Long managerId) {
        this.personName = personName;
        this.projectName = projectName;
        this.personId = personId;
        this.projectId = projectId;
        this.managerId = managerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(id, request.id) &&
                Objects.equals(personName, request.personName) &&
                Objects.equals(projectName, request.projectName) &&
                Objects.equals(personId, request.personId) &&
                Objects.equals(projectId, request.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personName, projectName, personId, projectId);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", personId=" + personId +
                ", projectId=" + projectId +
                '}';
    }
}
