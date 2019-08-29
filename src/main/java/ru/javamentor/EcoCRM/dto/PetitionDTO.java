package ru.javamentor.EcoCRM.dto;

import ru.javamentor.EcoCRM.model.User;

import java.time.LocalDate;
import java.util.List;

public class PetitionDTO {

    private LocalDate data;

    private String adress;

    private String area;

    private Long id;

    private List<User> userList;

    public PetitionDTO(LocalDate data, String adress, String area, Long id, List<User> userList) {
        this.data = data;
        this.adress = adress;
        this.area = area;
        this.id = id;
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
