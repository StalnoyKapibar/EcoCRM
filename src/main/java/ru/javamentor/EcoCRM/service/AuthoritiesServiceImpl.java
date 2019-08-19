package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.dao.AuthoritiesDao;
import ru.javamentor.EcoCRM.model.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("authoritiesService")
public class AuthoritiesServiceImpl extends AbstractServiceImpl<Authorities> implements AuthoritiesService {
}
