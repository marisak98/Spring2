package com.Java_Proyect.Spring.dao;

import com.Java_Proyect.Spring.models.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
    @PersistenceContext
     EntityManager entityManager;

    @Override
    public List<Users> getUsers() {
        String query = "FROM Users";
       return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Users users = entityManager.find(Users.class, id);
        entityManager.remove(users);
    }

    @Override
    public void newUser(Users users) {
        entityManager.merge(users);
    }
    @Override
    public boolean credentialsUsers(Users users){
        String query = "FROM Users WHERE email = :email AND password = :password";
        List<Users> listaUsers =  entityManager.createQuery(query)
                .setParameter("email", users.getEmail())
                .setParameter("password", users.getPassword())
                .getResultList();
        return !listaUsers.isEmpty();
    }
}
