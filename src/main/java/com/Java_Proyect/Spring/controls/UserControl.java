package com.Java_Proyect.Spring.controls;

import com.Java_Proyect.Spring.dao.UserDao;
import com.Java_Proyect.Spring.models.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControl {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/users")
    public List<Users> getUser2(){
       return userDao.getUsers();
    }
@RequestMapping(value = "api/userrs/{id}")
    public Users getUser(@PathVariable Long id){
            Users user = new Users();
            user.setId(id);
            user.setName("Luis");
            user.setSurname("Rodigres");
            user.setEmail("test@test.com");
            user.setPhone("09616479212");
            user.setPassword("pasword123");

    return user;
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void eliminarUsers(@PathVariable Long id) {

        userDao.eliminar(id);
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody Users users){
         userDao.newUser(users);
    }

}
