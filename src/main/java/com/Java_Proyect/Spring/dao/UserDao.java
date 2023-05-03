package com.Java_Proyect.Spring.dao;

import com.Java_Proyect.Spring.models.Users;

import java.util.List;

public interface UserDao {


    List<Users> getUsers();

    void eliminar(Long id);

    void newUser(Users users);

    Users credentialsUsers(Users users);


}
