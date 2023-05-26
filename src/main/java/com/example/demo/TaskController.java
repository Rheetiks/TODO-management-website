package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.tasks;
import com.example.demo.services.TaskService;
import com.example.demo.services.UserService;
@RestController
public class TaskController {
    @Autowired
    TaskService taskservice;
    @Autowired
    UserService userservice;

    @GetMapping("/view")
    public List<tasks> view(){
        return taskservice.view();
    }
    @PostMapping("/add")
    public List<tasks> add(@RequestBody tasks input){
        
       return  taskservice.add(input);
    }
    @PostMapping("/delete")
    @ResponseBody
    public String deleteTask(@RequestBody tasks input){
        taskservice.deleteTask(input);
        return input.getTaskName() ;
    }
    @PostMapping("/update")
    public List<tasks> updateTask(@RequestBody tasks input){
        taskservice.updateTask(input);
        return taskservice.view();
    }

    @GetMapping("/viewUser")
    public List<User> viewUser(){
        return userservice.viewUser();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userservice.addUser(user);
    }
    @PostMapping("/user/view")
    public List<tasks> viewUserTasks(@RequestBody User input){
        return taskservice.viewUserTasks(input);
    }
    @PostMapping("/login")
    // @ResponseBody
    public User logIn(@RequestBody User input){
        User u= new User();
        u=userservice.logIn(input);
        return u;
    }
    


}
