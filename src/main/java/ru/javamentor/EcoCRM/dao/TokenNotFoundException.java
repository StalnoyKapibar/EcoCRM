package ru.javamentor.EcoCRM.dao;

/**
 * Created by whitenoise on 24.08.19.
 */
public class TokenNotFoundException extends RuntimeException {
    public TokenNotFoundException(String message) {
        super(message);
    }
}
