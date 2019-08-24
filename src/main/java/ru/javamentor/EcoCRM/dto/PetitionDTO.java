package ru.javamentor.EcoCRM.dto;

import java.time.LocalDate;

public class PetitionDTO {
    private LocalDate data;
    private String adress;
    private String area;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PetitionDTO(LocalDate data, String adress, String area, long id) {
        this.data = data;
        this.adress = adress;
        this.area = area;
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
