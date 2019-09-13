package ru.javamentor.EcoCRM.service;

import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.model.Token;
@Service
public interface TokenService {
    
    Token loadTokenByEmail(String email);
    void deleteOldTokens();
    String loadEmailByValue(String token);
    void insert(Token token);
}
