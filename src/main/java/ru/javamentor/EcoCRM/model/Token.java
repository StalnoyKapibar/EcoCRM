package ru.javamentor.EcoCRM.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "tokens")
public class Token {

    @Id
    private String id;

    private String email;


    private String value;

    private long tokenCreateTime = System.currentTimeMillis();


    public Token(String email, String value) {
        this.email = email;
        this.value = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public long getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(long tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", value='" + value + '\'' +
                ", tokenCreateTime=" + tokenCreateTime +
                '}';
    }
}
