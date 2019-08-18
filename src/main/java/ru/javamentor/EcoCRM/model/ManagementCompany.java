package ru.javamentor.EcoCRM.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "management_company")
public class ManagementCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "inn")
    private String inn;

    @Column(name = "link")
    private String link;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "manager_surename")
    private String managerSurename;

    @Column(name = "manager_patronymic")
    private String managerPatronymic;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "clock")
    private String clock;

    @Column(name = "description")
    private String description;

    @Column(name="next_contact_date")
    private LocalDateTime nextContactDate;

    public LocalDateTime getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(LocalDateTime nextContactDate) {
        this.nextContactDate = nextContactDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerSurename() {
        return managerSurename;
    }

    public void setManagerSurename(String managerSurename) {
        this.managerSurename = managerSurename;
    }

    public String getManagerPatronymic() {
        return managerPatronymic;
    }

    public void setManagerPatronymic(String managerPatronymic) {
        this.managerPatronymic = managerPatronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
