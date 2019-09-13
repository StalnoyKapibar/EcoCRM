package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.TokenDao;
import ru.javamentor.EcoCRM.model.Token;

import java.security.SecureRandom;
import java.util.List;


@Service
public class TokenServiceImpl implements  TokenService{

    private final TokenDao tokenDao;
    @Autowired
    public TokenServiceImpl(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }

    private final Long TOKEN_LIFE_TIME = 30000L;

    public Token loadTokenByEmail(String email)  throws UsernameNotFoundException{
        Token token = tokenDao.getTokenByEmail(email);
        if(token == null) {
            throw new UsernameNotFoundException("Token with " + email + " not found");
        }
        return token;
    }

    public String loadEmailByValue(String value)  throws UsernameNotFoundException{
        String email = tokenDao.getTokenByValue(value).getEmail();
        if(email == null) {
            throw new UsernameNotFoundException("Token with " + email + " not found");
        }
        return email;
    }
    public void deleteOldTokens() {
        tokenDao.deleteByTokenCreateTime(System.currentTimeMillis() - TOKEN_LIFE_TIME);
    }

    @Override
    public void insert(Token token) {
        tokenDao.insert(token);

    }
}

