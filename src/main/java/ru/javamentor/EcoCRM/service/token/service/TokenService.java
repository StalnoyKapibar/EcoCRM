package ru.javamentor.EcoCRM.service.token.service;


import ru.javamentor.EcoCRM.model.Token;
import ru.javamentor.EcoCRM.service.AbstractService;

public interface TokenService extends AbstractService<Token> {

    Token loadTokenByCode(String code);

    void deleteOldTokens();
}
