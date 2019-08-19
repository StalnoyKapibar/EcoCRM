package ru.javamentor.EcoCRM.dao;

import org.springframework.security.core.userdetails.UserDetails;
import ru.javamentor.EcoCRM.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class UserDetailsDaoImpl extends AbstractDaoImpl<UserDetails> implements UserDetailsDao {



}
