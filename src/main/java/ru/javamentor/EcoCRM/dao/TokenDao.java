package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Token;


public interface TokenDao extends AbstractDao<Token>{

    void deleteOldTokens();

}
