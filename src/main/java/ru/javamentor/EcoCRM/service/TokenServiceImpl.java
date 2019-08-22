package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.TokenDao;
import ru.javamentor.EcoCRM.model.Token;
import ru.javamentor.EcoCRM.model.User;

import java.security.SecureRandom;


@Service
public class TokenServiceImpl extends AbstractServiceImpl<Token> implements TokenService{

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
    public Token loadTokenByEmail(String email)  throws UsernameNotFoundException{
        Token token = tokenDao.findByFieldNameAndValue("email", email);
        if(token == null)
        //todo
        {
            throw new UsernameNotFoundException("Token with " + email + " not found");
        }
        return token;
    }

    @Override
    public void deleteOldTokens() {
        tokenDao.deleteOldTokens();
    }


}

