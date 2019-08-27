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

    @Column(name = "token_create_time")
    private long tokenCreateTime = System.currentTimeMillis();

    public Token() {

    }

    public Token(String email, String token) {
        this.email = email;
        this.token = token;
    }

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


    public long getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(long tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }

}
