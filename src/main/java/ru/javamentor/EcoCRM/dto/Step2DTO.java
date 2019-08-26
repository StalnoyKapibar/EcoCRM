package ru.javamentor.EcoCRM.dto;

import ru.javamentor.EcoCRM.model.ManagementCompany;

public class Step2DTO implements StepDTO {

    private Long id;

    private ManagementCompany company;

    public Step2DTO() {

    }

    public Step2DTO(Long id, ManagementCompany company) {
        this.id = id;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ManagementCompany getCompany() {
        return company;
    }

    public void setCompany(ManagementCompany company) {
        this.company = company;
    }
}
