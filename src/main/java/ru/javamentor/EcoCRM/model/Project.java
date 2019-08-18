package ru.javamentor.EcoCRM.model;

import javax.persistence.*;

@Entity
@Table
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    Point point;


}
