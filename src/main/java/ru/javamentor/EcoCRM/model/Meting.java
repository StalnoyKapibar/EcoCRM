package ru.javamentor.EcoCRM.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "mitings")
public class Meting {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column (name = "contractor")
    private Contractor contractor;

    @Column(name = "management_company")
    private ManagementCompany managementCompany;

    @Column(name = "date")
    private LocalDateTime dateTime;

    public Meting() {

    }

    public LocalDateTime getDateTime() {
          return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public ManagementCompany getManagementCompany() {
        return managementCompany;
    }

    public void setManagementCompany(ManagementCompany managementCompany) {
        this.managementCompany = managementCompany;
    }
}
