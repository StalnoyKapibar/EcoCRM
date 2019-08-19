package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.AuthoritiesDao;
import ru.javamentor.EcoCRM.model.Authority;
import org.springframework.stereotype.Service;


@Service
public class AuthoritiesServiceImpl extends AbstractServiceImpl<Authority> implements AuthoritiesService {

    @Autowired
    public AuthoritiesServiceImpl(AuthoritiesDao authoritiesDao) {
        super(authoritiesDao);
    }
}
