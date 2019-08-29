package ru.javamentor.EcoCRM.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "contractors")
public class Contractor implements Serializable {  //заготовитель (подрядчик изготовления контейнеров)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;  //компания

    @Column (name = "row_type")
    private String rowType;  //тип сырья

    @Column(name = "link")
    private String link;  //веб-сайт компании

    @Column(name = "contact_person")
    private String contactPerson;  //имя и фамилия представителя компании

    @Column(name = "phone_number")
    private String phoneNumber;  //номер компании

    @Column(name = "link_by_person")
    private String linkByPerson;  //веб-сайт или страница заготовителя

    @Column(name = "collector_type")
    private String collectorType;  //тип накопителя

    @Column(name = "description")
    private String description;  //условия вывоза

    @OneToMany
    private List<Comment> comments;

    public Contractor() {

    }

    public Contractor(String name, String rowType, String link, String contactPerson, String phoneNumber,
                      String linkByPerson, String collectorType, String description) {
        this.name = name;
        this.rowType = rowType;
        this.link = link;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.linkByPerson = linkByPerson;
        this.collectorType = collectorType;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRowType() {
        return rowType;
    }

    public void setRowType(String rowType) {
        this.rowType = rowType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLinkByPerson() {
        return linkByPerson;
    }

    public void setLinkByPerson(String linkByPerson) {
        this.linkByPerson = linkByPerson;
    }

    public String getCollectorType() {
        return collectorType;
    }

    public void setCollectorType(String collectorType) {
        this.collectorType = collectorType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
