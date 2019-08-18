package service;

import dao.AuthoritiesDao;
import entity.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("authoritiesService")
public class AuthoritiesServiceImpl implements  AuthoritiesService {

    @Autowired
    private AuthoritiesDao authoritiesDao;

    @Transactional
    public Authorities getAuthority(int id) {
        return authoritiesDao.getAuthority(id);

    }

    @Transactional
    public List<Authorities> listAllAuthorities() {

        return authoritiesDao.listAllAuthorities();
    }


    @Transactional
    public Authorities getAuthorityByName(String authorityName) {
        return authoritiesDao.getAuthorityByName(authorityName);
    }
}
