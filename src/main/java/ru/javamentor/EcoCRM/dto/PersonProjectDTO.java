package ru.javamentor.EcoCRM.dto;

public class PersonProjectDTO {

    private String id = "id";

    private String number = "step";

    private String time = "00:00";

    private String area = "Нет района";

    public PersonProjectDTO() {

    }

    public PersonProjectDTO(String id, String number, String time, String area) {
        this.id = id;
        this.number = number;
        this.time = time;
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
