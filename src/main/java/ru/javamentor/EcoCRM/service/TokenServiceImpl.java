package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.TokenDao;
import ru.javamentor.EcoCRM.model.Token;

import java.security.SecureRandom;


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

    @Override
    public String encodeToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String genToken = bytes.toString();
        return genToken;
    }

    @Override
    public Token loadTokenByEmail(String email)  throws UsernameNotFoundException{
        Token token = tokenDao.findByFieldNameAndValue("email", email);
        if(token == null) {
            throw new UsernameNotFoundException("Token with " + email + " not found");
        }
        return token;
    }

    @Override
    public String loadEmailByToken(String token)  throws UsernameNotFoundException{
        String email = tokenDao.findByFieldNameAndValue("token", token).getEmail();
        if(email== null) {
            throw new UsernameNotFoundException("Token with " + email + " not found");
        }
        return email;
    }
    @Override
    public void deleteOldTokens() {
       tokenDao.deleteOldTokens();
    }
}

