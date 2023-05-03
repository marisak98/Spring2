package com.Java_Proyect.Spring.controls;

import com.Java_Proyect.Spring.dao.UserDao;
import com.Java_Proyect.Spring.models.Users;
import com.Java_Proyect.Spring.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Constants;
import de.mkammerer.argon2.Argon2Factory;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControl {
    @Autowired
    private UserDao userDao;
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<Users> getUser(@RequestHeader(value = "Authorization", required=false)String token) {

        if (!validarToken(token)){
            return null;
        }
       return userDao.getUsers();

    }

    private boolean validarToken(String token){
        String userID = jwtUtil.getKey(token);
       return userID != null;

    }

    @RequestMapping(value = "api/users1")
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
    public void eliminarUsers(@RequestHeader(value = "Authorization", required=false) String token,
                              @PathVariable Long id) {
            if (!validarToken(token)){
                return;
            }
        userDao.eliminar(id);
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody Users users) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash =  argon2.hash(1, 1024, 1, users.getPassword());
        users.setPassword(hash);
         userDao.newUser(users);
    }

}
