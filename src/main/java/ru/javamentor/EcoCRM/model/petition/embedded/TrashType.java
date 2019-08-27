package ru.javamentor.EcoCRM.model.petition.embedded;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TrashType {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "type_name")
    private String type;

    public TrashType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}



