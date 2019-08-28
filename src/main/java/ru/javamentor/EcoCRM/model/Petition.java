package ru.javamentor.EcoCRM.model;

import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.petition.embedded.TrashType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="petitions")
public class Petition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name= "contact_information")
    private String contactInformation;

    @Column(name = "petitioner_type")
    private String petitionerType;

    @Column(name = "activity_type")
    private String activityType;

    @ElementCollection
    @CollectionTable(name="type_of_raw_material", joinColumns=@JoinColumn(name="petition_id"))
    private List<String> typeOfRawMaterial;

    @Column(name = "address_home")
    private String addressHome;

    @Column(name = "house_district")
    private String houseDistrict;

    @Column(name = "flats_count")
    private String flatsCount;

    @Column(name = "management_company_type")
    private String managementCompanyType;

    @Column(name = "available_council")
    private String availableCouncil;

    @Column (name = "management_organization_relation")
    private String managementOrganizationRelation;

    @Column(name = "management_company_contacts")
    private String managementCompanyContacts;

    @Column(name = "additional_information")
    private String additionalInformation;

    @Column(name = "container_available")
    private String containerAvailable;

    @Column (name = "container_size")
    private String containerSize;

    @Column (name = "container_owner")
    private String containerOwner;

    @Column(name = "garbage_available")
    private String garbageAvailable;

    @Column(name = "export_garbage")
    private String exportGarbage;

    @Column(name = "agreement")
    private String agreement;

    @Column (name = "data")
    private LocalDate data;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.TODO;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable(
            name ="petitions_users",
            joinColumns = @JoinColumn(name = "petition_id"),
            inverseJoinColumns = @JoinColumn(name = "user_number")
    )
    private Set<User> userPetition;

    public Petition() {}

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

    public String getPetitionerType() {
        return petitionerType;
    }

    public void setPetitionerType(String petitionerType) {
        this.petitionerType = petitionerType;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public List<String> getTypeOfRawMaterial() {
        return typeOfRawMaterial;
    }

    public void setTypeOfRawMaterial(List<String> typeOfRawMaterial) {
        this.typeOfRawMaterial = typeOfRawMaterial;
    }

    public String getAddressHome() {
        return addressHome;
    }

    public void setAddressHome(String addressHome) {
        this.addressHome = addressHome;
    }

    public String getHouseDistrict() {
        return houseDistrict;
    }

    public void setHouseDistrict(String houseDistrict) {
        this.houseDistrict = houseDistrict;
    }

    public String getFlatsCount() {
        return flatsCount;
    }

    public void setFlatsCount(String flatsCount) {
        this.flatsCount = flatsCount;
    }

    public String getManagementCompanyType() {
        return managementCompanyType;
    }

    public void setManagementCompanyType(String managementCompanyType) {
        this.managementCompanyType = managementCompanyType;
    }

    public String getAvailableCouncil() {
        return availableCouncil;
    }

    public void setAvailableCouncil(String availableCouncil) {
        this.availableCouncil = availableCouncil;
    }

    public String getManagementOrganizationRelation() {
        return managementOrganizationRelation;
    }

    public void setManagementOrganizationRelation(String managementOrganizationRelation) {
        this.managementOrganizationRelation = managementOrganizationRelation;
    }

    public String getManagementCompanyContacts() {
        return managementCompanyContacts;
    }

    public void setManagementCompanyContacts(String managementCompanyContacts) {
        this.managementCompanyContacts = managementCompanyContacts;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getContainerAvailable() {
        return containerAvailable;
    }

    public void setContainerAvailable(String containerAvailable) {
        this.containerAvailable = containerAvailable;
    }

    public String getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(String containerSize) {
        this.containerSize = containerSize;
    }

    public String getContainerOwner() {
        return containerOwner;
    }

    public void setContainerOwner(String containerOwner) {
        this.containerOwner = containerOwner;
    }

    public String getGarbageAvailable() {
        return garbageAvailable;
    }

    public void setGarbageAvailable(String garbageAvailable) {
        this.garbageAvailable = garbageAvailable;
    }

    public String getExportGarbage() {
        return exportGarbage;
    }

    public void setExportGarbage(String exportGarbage) {
        this.exportGarbage = exportGarbage;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<User> getUserPetition() {
        return userPetition;
    }

    public void setUserPetition(Set<User> userPetition) {
        this.userPetition = userPetition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
