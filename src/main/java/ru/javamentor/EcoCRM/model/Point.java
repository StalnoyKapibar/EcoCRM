package ru.javamentor.EcoCRM.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "points")
public class Point implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lat", nullable = false)
    private Float latitudeY;

    @Column(name = "lng", nullable = false)
    private Float longitudeX;

    public Point() {
    }

    public Point(Float latitudeY, Float longitudeX) {
        this.latitudeY = latitudeY;
        this.longitudeX = longitudeX;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLatitudeY() {
        return latitudeY;
    }

    public void setLatitudeY(Float latitudeY) {
        this.latitudeY = latitudeY;
    }

    public Float getLongitudeX() {
        return longitudeX;
    }

    public void setLongitudeX(Float longitudeX) {
        this.longitudeX = longitudeX;
    }
}
