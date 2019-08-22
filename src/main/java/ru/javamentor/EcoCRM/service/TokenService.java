package ru.javamentor.EcoCRM.service;


import org.springframework.security.core.userdetails.UserDetails;
import ru.javamentor.EcoCRM.model.Token;

public interface TokenService extends AbstractService<Token> {
    String encodeToken();
    Token loadTokenByEmail(String email);
}
