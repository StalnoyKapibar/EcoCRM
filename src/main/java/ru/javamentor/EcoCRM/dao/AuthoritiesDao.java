package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Authorities;

import java.util.List;

/**
 * Created by whitenoise on 18.08.19.
 */
//todo разные папки
public interface AuthoritiesDao {

    Authorities getAuthorityByName(String authorityName);

    Authorities getAuthority(int id);

    List<Authorities> listAllAuthorities();

}
