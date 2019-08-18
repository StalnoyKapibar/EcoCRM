package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    //Java Persistence API - Entity Manager and JPQL using

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserByUsername(String username) {


        Query query = entityManager.createQuery("select u FROM User u where u.username=:username", User.class);

        query.setParameter("username", username);

        User user = (User)query.getSingleResult();

        //diagnostics:
        System.out.println("Finded user" + user.getUsername().toUpperCase());

        return user;
    }

    @Override
    public void insertUser(User user) {

        entityManager.persist(user);

        //diagnostics:
        System.out.println("User successfully saved in database. User details:  " + user.getUsername());

    }

    @Override
    public List<User> listAllUsers() {

        List<User> userList = entityManager.createQuery("from User").getResultList();

        //diagnostics:
        for (User user : userList) {
            System.out.println("UserList " + user.getUsername());
        }

        return userList;
    }

    @Override
    public void deleteUser(int id) {

        User user = entityManager.find(User.class, id);

        if (user != null) {

            entityManager.remove(user);
        }
        //diagnostics:
        System.out.println("User succesfully deleted. User details: " + user.getUsername());

    }

    @Override
    public User getUser(int id) {

        User user = entityManager.find(User.class, id);

        //diagnostics:
        System.out.println("User successfully loaded. User details: " + user.getUsername());

        return user;
    }

    @Override
    public void updateUser(User user) {

        entityManager.merge(user);

        //diagnostics:
        System.out.println("User successfully updated. User details: " + user.getUsername());
    }



}
