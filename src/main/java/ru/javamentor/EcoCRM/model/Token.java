package ru.javamentor.EcoCRM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class Token {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "token")
    private String token;

    public Token() {

    }

//    public Token(String email) {
//        this.email = email;
//
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void encodeToken() {

        String origin = "root";
        int encoded = origin.hashCode();
    }
}
