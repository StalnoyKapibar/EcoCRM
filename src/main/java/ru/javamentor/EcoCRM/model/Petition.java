package ru.javamentor.EcoCRM.model;

import javax.persistence.*;


@Entity
@Table(name="petition")
public class Petition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    //todo naming convention
    @Column(name = "user_name")
    private String userName;

    @Column(name="contactInformation")
    private String contactInformation; // профиль в соцсети или номер телефона

   @Column(name ="status_Home")
    private String statusHome;

   @Column(name="separate_collection")
   private String separateCollection;

   @Column(name="type_of_raw_material")
   private String typeOfRawMaterial;

    public String getTypeOfRawMaterial() {
        return typeOfRawMaterial;
    }

    public void setTypeOfRawMaterial(String typeOfRawMaterial) {
        this.typeOfRawMaterial = typeOfRawMaterial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getStatusHome() {
        return statusHome;
    }

    public void setStatusHome(String statusHome) {
        this.statusHome = statusHome;
    }

    public String getSeparateCollection() {
        return separateCollection;
    }

    public void setSeparateCollection(String separateCollection) {
        this.separateCollection = separateCollection;
    }
}
