package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Token;

public interface TokenService extends AbstractService<Token> {

    String encodeToken();

    Token loadTokenByEmail(String email);

    String loadEmailByToken(String token);
}
