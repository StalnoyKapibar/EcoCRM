package ru.javamentor.EcoCRM.model;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "manager_surname")
    private String managerSurname;

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

    public ManagementCompany() {

    }

    public ManagementCompany(String name, String inn, String link, String managerName, String managerSurname, String managerPatronymic, String phoneNumber, String email, String clock, String description, LocalDateTime nextContactDate) {
        this.name = name;
        this.inn = inn;
        this.link = link;
        this.managerName = managerName;
        this.managerSurname = managerSurname;
        this.managerPatronymic = managerPatronymic;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.clock = clock;
        this.description = description;
        this.nextContactDate = nextContactDate;
    }

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

    public String getManagerSurname() {
        return managerSurname;
    }

    public void setManagerSurname(String managerSurname) {
        this.managerSurname = managerSurname;
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
