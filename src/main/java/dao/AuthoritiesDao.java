package dao;

import entity.Authorities;

import java.util.List;

/**
 * Created by whitenoise on 18.08.19.
 */
public interface AuthoritiesDao {

    Authorities getAuthorityByName(String authorityName);

    Authorities getAuthority(int id);

    List<Authorities> listAllAuthorities();

}
