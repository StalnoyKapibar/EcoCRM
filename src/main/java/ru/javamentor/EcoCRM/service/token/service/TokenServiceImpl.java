package ru.javamentor.EcoCRM.service.token.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.TokenDao;
import ru.javamentor.EcoCRM.model.Token;
import ru.javamentor.EcoCRM.service.AbstractServiceImpl;
import ru.javamentor.EcoCRM.service.token.service.TokenService;


@Service
public class TokenServiceImpl extends AbstractServiceImpl<Token> implements TokenService {

    @Value("${tokenTTL}")
    private long tokenTTL;

    private TokenDao tokenDao;

    @Autowired
    public TokenServiceImpl(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }

    @Override
    public TokenDao getDao() {
        return tokenDao;
    }

    @Override
    public Token loadTokenByCode(String code)  throws UsernameNotFoundException{

        try {
            Token token = tokenDao.findByFieldNameAndValue("code", code);
            return token;
        } catch (NullPointerException e) {

            throw new NullPointerException("Token with " + code + " not found");
        }

    }
    @Override
    public void deleteOldTokens() {
        tokenDao.deleteOldTokens();
    }
}

