package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskDao;
import com.example.demo.model.User;
import com.example.demo.model.tasks;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;
    public List<tasks> view(){
        return taskDao.view();       
    }
    public List<tasks> add(tasks task){
        return taskDao.addTask(task);   
    }
    public void deleteTask(tasks task){
        taskDao.deleteTask(task);   
    }
    public void updateTask(tasks task){
        taskDao.updateTask(task);   
    }
    public List<tasks> viewUserTasks(User user){
        return taskDao.viewUserTasks(user);   
    }
    
}
