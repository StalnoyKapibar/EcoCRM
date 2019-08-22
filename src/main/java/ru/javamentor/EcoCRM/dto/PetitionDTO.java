package ru.javamentor.EcoCRM.dto;

import java.time.LocalDate;

public class PetitionDTO {
    private LocalDate data;
    private String adress;
    private String area;

    public PetitionDTO(LocalDate data, String adress, String area) {
        this.data = data;
        this.adress = adress;
        this.area = area;
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
