package ru.javamentor.EcoCRM.model;

import javax.persistence.*;
import java.time.LocalDate;

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


    @Column(name = "adres_home")
    private String adresHome;

    @Column(name = "house_area")
    private String houseArea;

    @Column(name = "count_of_apartments")
    private String countOfApartments;

    @Column(name = "home_control_form")
    private String homeControlForm;

    @Column(name = "house_council")
    private String houseCouncil;

    @Column (name = "management_organization")
    private String managementOrganization;

    @Column(name = "board_house_contact_information")
    private String boardHouseContactInformation;

    @Column(name = "additional_information")
    private String additionalInformation;

    @Column(name = "container_site")
    private String containerSite;

    @Column (name = "container_size")
    private String containerSize;

    @Column (name = "container_owner")
    private String containerOwner;

    @Column(name = "why_not_container")
    private String whyNotContainer;

    @Column(name = "garbage")
    private String garbage;

    @Column(name = "export_garbage")
    private String exportGarbage;

    @Column(name = "yes")
    private String yes;

    @Column (name = "data")
    LocalDate data;



    public Petition() {

    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Petition(String email, String userName, String contactInformation, String statusHome, String separateCollection, String typeOfRawMaterial, String adresHome, String houseArea, String countOfApartments, String homeControlForm,
                    String houseCouncil, String managementOrganization, String boardHouseContactInformation, String additionalInformation, String containerSite, String containerSize, String containerOwner, String whyNotContainer, String garbage,
                    String exportGarbage, String yes, LocalDate data) {
        this.email = email;
        this.userName = userName;
        this.contactInformation = contactInformation;
        this.statusHome = statusHome;
        this.separateCollection = separateCollection;
        this.typeOfRawMaterial = typeOfRawMaterial;
        this.adresHome = adresHome;
        this.houseArea = houseArea;
        this.countOfApartments = countOfApartments;
        this.homeControlForm = homeControlForm;
        this.houseCouncil = houseCouncil;
        this.managementOrganization = managementOrganization;
        this.boardHouseContactInformation = boardHouseContactInformation;
        this.additionalInformation = additionalInformation;
        this.containerSite = containerSite;
        this.containerSize  =containerSize;
        this.containerOwner = containerOwner;
        this.whyNotContainer  = whyNotContainer;
        this.garbage = garbage;
        this.exportGarbage = exportGarbage;
        this.yes = yes;
        this.data = data;

    }

    public String getExportGarbage() {
        return exportGarbage;
    }

    public void setExportGarbage(String exportGarbage) {
        this.exportGarbage = exportGarbage;
    }

    public String getWhyNotContainer() {
        return whyNotContainer;
    }

    public void setWhyNotContainer(String whyNotContainer) {
        this.whyNotContainer = whyNotContainer;
    }

    public String getGarbage() {
        return garbage;
    }

    public void setGarbage(String garbage) {
        this.garbage = garbage;
    }

    public String getContainerOwner() {
        return containerOwner;
    }

    public void setContainerOwner(String containerOwner) {
        this.containerOwner = containerOwner;
    }

    public String getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(String containerSize) {
        this.containerSize = containerSize;
    }

    public String getContainerSite() {
        return containerSite;
    }

    public void setContainerSite(String containerSite) {
        this.containerSite = containerSite;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getBoardHouseContactInformation() {
        return boardHouseContactInformation;
    }

    public void setBoardHouseContactInformation(String boardHouseContactInformation) {
        this.boardHouseContactInformation = boardHouseContactInformation;
    }

    public String getManagementOrganization() {
        return managementOrganization;
    }

    public void setManagementOrganization(String managementOrganization) {
        this.managementOrganization = managementOrganization;
    }

    public String getHouseCouncil() {
        return houseCouncil;
    }

    public void setHouseCouncil(String houseCouncil) {
        this.houseCouncil = houseCouncil;
    }

    public String getHomeControlForm() {
        return homeControlForm;
    }

    public void setHomeControlForm(String homeControlForm) {
        this.homeControlForm = homeControlForm;
    }

    public String getCountOfApartments() {
        return countOfApartments;
    }

    public void setCountOfApartments(String countOfApartments) {
        this.countOfApartments = countOfApartments;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresHome() {
        return adresHome;
    }

    public void setAdresHome(String adresHome) {
        this.adresHome = adresHome;
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
