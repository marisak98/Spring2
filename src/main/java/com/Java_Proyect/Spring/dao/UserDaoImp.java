package com.Java_Proyect.Spring.dao;

import com.Java_Proyect.Spring.models.Users;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
    public Users credentialsUsers(Users users){
        String query = "FROM Users WHERE email = :email";
        List<Users> listaUsers =  entityManager.createQuery(query)
                .setParameter("email", users.getEmail())
                .getResultList();

        if (listaUsers.isEmpty()){
            return  null;
        }

        String listaHashed = listaUsers.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(listaHashed, users.getPassword())){
            return  listaUsers.get(0);
        }
        return null;
    }
}
