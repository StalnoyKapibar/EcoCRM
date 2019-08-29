package ru.javamentor.EcoCRM.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "meetings")
public class Meeting {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Contractor contractor;

    @OneToOne
    private ManagementCompany managementCompany;

    @Column(name = "date")
    private LocalDate dateTime;

    public Meeting() {

    }

    public Meeting(Contractor contractor, ManagementCompany managementCompany, LocalDate dateTime) {
        this.contractor = contractor;
        this.managementCompany = managementCompany;
        this.dateTime = dateTime;
    }

    public LocalDate getDateTime() {
          return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
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
