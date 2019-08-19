package ru.javamentor.EcoCRM.model;

import javax.persistence.*;

@Entity
@Table(name = "contractors")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column (name = "row_type")
    private String rowType;

    @Column(name = "link")
    private String link;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "link_by_person")
    private String linkByPerson;

    @Column(name = "collector_type")
    private String collectorType;

    @Column(name = "disposal_conditions")
    private String disposalСonditions;

    public Contractor() {

    }

    public Contractor(String name, String rowType, String link, String contactPerson, String phoneNumber, String linkByPerson, String collectorType, String disposalСonditions) {
        this.name = name;
        this.rowType = rowType;
        this.link = link;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.linkByPerson = linkByPerson;
        this.collectorType = collectorType;
        this.disposalСonditions = disposalСonditions;
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

    public String getDisposalСonditions() {
        return disposalСonditions;
    }

    public void setDisposalСonditions(String disposalСonditions) {
        this.disposalСonditions = disposalСonditions;
    }
}
