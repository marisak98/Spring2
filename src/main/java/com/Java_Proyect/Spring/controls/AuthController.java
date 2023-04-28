package com.Java_Proyect.Spring.controls;

import com.Java_Proyect.Spring.dao.UserDao;
import com.Java_Proyect.Spring.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody Users users){

        if (userDao.credentialsUsers(users)) {
            return "OK";
        }
        return "[-] FAIL";
    }

}
