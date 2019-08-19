package ru.javamentor.EcoCRM.model;

import javax.persistence.*;

@Entity
@Table(name = "contractor")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    private String disposalConditions;

    public Contractor() {

    }

    public Contractor(String name, String rowType, String link, String contactPerson, String phoneNumber, String linkByPerson, String collectorType, String disposalConditions) {
        this.name = name;
        this.rowType = rowType;
        this.link = link;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.linkByPerson = linkByPerson;
        this.collectorType = collectorType;
        this.disposalConditions = disposalConditions;
    }

    public String getCollectorType() {
        return collectorType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRowType(String rowType) {
        this.rowType = rowType;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLinkByPerson(String linkByPerson) {
        this.linkByPerson = linkByPerson;
    }

    public void setCollectorType(String collectorType) {
        this.collectorType = collectorType;
    }

    public void setDisposalConditions(String disposalConditions) {
        this.disposalConditions = disposalConditions;
    }
}
