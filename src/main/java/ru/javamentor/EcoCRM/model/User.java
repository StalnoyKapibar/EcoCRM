package ru.javamentor.EcoCRM.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "email")
    private String email;

    @Column(name = "vk_link")
    private String link;

    @Column(name = "profession")
    private String profession;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled = false;

    @Column(name = "user_status")
    private UserStatus status = UserStatus.ACTIVE;

    @Column(name = "not_to_do")
    private String notToDo;    //чем волонтер не хочет заниматься

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable(
            name ="users_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private List<Authority> authorities;

    public User() {
    }

    public User(String email, String password, boolean enabled) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String name, String surname, String patronymic, String email, String link,  String profession, String password, boolean enabled, String notToDo, List<Authority> authorities, UserStatus status) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.link = link;
        this.profession = profession;
        this.password = password;
        this.enabled = enabled;
        this.notToDo = notToDo;
        this.authorities = authorities;
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled() {
        this.enabled = status != UserStatus.BLOCKED;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
            this.status = status;
    }
    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNotToDo() {
        return notToDo;
    }

    public void setNotToDo(String notToDo) {
        this.notToDo = notToDo;
    }
}
