package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.TokenDao;
import ru.javamentor.EcoCRM.model.Token;


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
    public Token loadTokenByCode(String code)  throws UsernameNotFoundException{
        Token token = tokenDao.findByFieldNameAndValue("code", code);
        if(token == null)
        //todo
        {
            System.out.println("Token Not Found");
            //throw new UsernameNotFoundException("Token with " + token + " not found");
        }
        return token;
    }
    @Override
    public void deleteOldTokens() {
        tokenDao.deleteOldTokens();
    }
}

