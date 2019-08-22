package ru.javamentor.EcoCRM.model;

import javax.persistence.*;

@Entity
@Table(name="petitions")
public class Petition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name= "contact_information")
    private String contactInformation; // профиль в соцсети или номер телефона

    @Column(name ="status_home")
    private String statusHome;

    @Column(name="separate_collection")
    private String separateCollection;

    @Column(name="type_of_raw_material")
    private String typeOfRawMaterial;


    public Petition() {

    }

    public Petition(String email, String userName, String contactInformation, String statusHome, String separateCollection, String typeOfRawMaterial) {
        this.email = email;
        this.userName = userName;
        this.contactInformation = contactInformation;
        this.statusHome = statusHome;
        this.separateCollection = separateCollection;
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

    public String getTypeOfRawMaterial() {
        return typeOfRawMaterial;
    }

    public void setTypeOfRawMaterial(String typeOfRawMaterial) {
        this.typeOfRawMaterial = typeOfRawMaterial;
    }
}
