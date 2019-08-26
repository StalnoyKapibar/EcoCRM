package ru.javamentor.EcoCRM.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;


    @ElementCollection
    @CollectionTable(name="link", joinColumns=@JoinColumn(name="report_id"))
    private List<String> link;

    public Report() {

    }

    public Report(String description, List <String>link) {
        this.description = description;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getLink() {
        return link;
    }

    public void setLink(List link) {
        this.link = link;
    }
}