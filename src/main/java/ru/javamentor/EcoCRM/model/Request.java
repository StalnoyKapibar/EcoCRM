package ru.javamentor.EcoCRM.model;

import javax.persistence.*;

@Entity
@Table(name = "requests")
public class Request {

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
    public Request(){

    }

    public Request(String personName, String projectName, Long personId, Long projectId) {
        this.personName = personName;
        this.projectName = projectName;
        this.personId = personId;
        this.projectId = projectId;
    }
}
