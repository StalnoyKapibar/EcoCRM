package ru.javamentor.EcoCRM.dto;


import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.UserStatus;

public class CurrentUserDTO {
    private long id;
    private String name;
    private String surname;
    private String phone;
    private String patronymic;
    private String email;
    private String link;
    private String profession;
    private String notToDo;
    private UserStatus status;
    private String photo;

    public CurrentUserDTO() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNotToDo() {
        return notToDo;
    }

    public void setNotToDo(String notToDo) {
        this.notToDo = notToDo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
