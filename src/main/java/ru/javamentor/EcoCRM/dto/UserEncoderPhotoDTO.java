package ru.javamentor.EcoCRM.dto;

import ru.javamentor.EcoCRM.model.embedded.UserStatus;

import java.io.Serializable;

public class UserEncoderPhotoDTO implements Serializable {

    private Long id;

    private String name;

    private String surname;

    private UserStatus status;

    private String photo;

    public UserEncoderPhotoDTO(Long id, String name, String surname, UserStatus status, String photo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
