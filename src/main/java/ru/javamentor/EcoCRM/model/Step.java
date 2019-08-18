package ru.javamentor.EcoCRM.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "step")
public class Step implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private Status status;



}
