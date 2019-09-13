package ru.javamentor.EcoCRM.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.javamentor.EcoCRM.model.Token;


public interface TokenDao extends MongoRepository<Token, String> {

    Token getTokenByEmail(String email);
    Token getTokenByValue(String value);
    @Query("{'tokenCreateTime' : {$lt : ?0}}")
    void deleteByTokenCreateTime(long maxLifeTime);
}
