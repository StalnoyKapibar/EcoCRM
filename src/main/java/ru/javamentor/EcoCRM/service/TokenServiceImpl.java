package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.TokenDao;
import ru.javamentor.EcoCRM.model.Token;


@Service
public class TokenServiceImpl extends AbstractServiceImpl<Token> implements TokenService{


    private TokenDao tokenDao;

    @Autowired
    public TokenServiceImpl(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }

    @Override
    public TokenDao getDao() {
        return tokenDao;
    }


}

