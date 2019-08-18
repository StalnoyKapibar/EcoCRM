package ru.javamentor.EcoCRM.service;


import ru.javamentor.EcoCRM.model.Authorities;

import java.util.List;

public interface AuthoritiesService {

    Authorities getAuthorityByName(String authorityName);

    Authorities getAuthority(int id);

    List<Authorities> listAllAuthorities();
}
