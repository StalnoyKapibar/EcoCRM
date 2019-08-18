package service;

import dao.AuthoritiesDao;
import entity.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("authoritiesService")
public class AuthoritiesServiceImpl implements  AuthoritiesService {

    @Autowired
    private AuthoritiesDao authoritiesDao;

    @Override
    public Authorities getAuthorityByName(String authorityName) {
        return null;
    }

    @Override
    public Authorities getAuthority(int id) {
        return null;
    }

    @Override
    public List<Authorities> listAllAuthorities() {
        return null;
    }
}
