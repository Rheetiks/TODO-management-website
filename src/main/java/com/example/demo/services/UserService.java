package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Service
public class UserService {
    @Autowired
    UserDao userdao;
    public List<User> viewUser(){
       return userdao.viewUser();
    }
    public User addUser(User user){
       return userdao.addUser(user);
    }
    public User logIn(User user){
        return userdao.logIn(user);
    }
    

}
