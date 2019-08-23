package ru.javamentor.EcoCRM.model;

import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Configuration
@Table(name = "token")
public class Token {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "email")
    private String email;

    @Column(name = "token_create_time")
    private long tokenCreateTime = System.currentTimeMillis();

    public Token() {
    }

    public Token(String email, String code) {
        this.email = email;
        this.code = code;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(long tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }
}
