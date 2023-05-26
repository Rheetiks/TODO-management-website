package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Rowmapper;
import com.example.demo.UserRowMapper;
import com.example.demo.model.User;
import com.example.demo.model.tasks;
@Repository
public class TaskDao {
    @Autowired
    private JdbcTemplate jdbc;
    public static User logUser=new User();

    public List<tasks> view(){
        String q="select * from list";
        List <tasks> l=this.jdbc.query(q, new Rowmapper());
        return l;
    }

    public List<tasks> addTask(tasks task){
        String q= "insert into list (user_id,task_name) values (?,?)";
        this.jdbc.update(q,logUser.getUserId(),task.getTaskName());
        q="select * from list where user_id=?";
        List<tasks> l=this.jdbc.query(q,new Rowmapper(),logUser.getUserId());
        return l;
    }
    public void deleteTask(tasks task){
        String q="select * from list where task_id=?";
        this.jdbc.queryForObject(q,new Rowmapper(),task.getTaskId());
        q= "Delete from list where task_id=?";
        this.jdbc.update(q,task.getTaskId());
        
    }
    public void updateTask(tasks task){
        String q= "update list set task_name=? where task_id=?";
        this.jdbc.update(q,task.getTaskName(),task.getTaskId());
    }
    public List<tasks> viewUserTasks(User user){
        try{
            String q="select * from list where user_id in(select user_id from user where username =? && password=?)";  
            List <tasks> l= this.jdbc.query(q, new Rowmapper(),user.getUserName(),user.getUserPassword());
            q="select * from user where username=? and password=?";
            logUser=this.jdbc.queryForObject(q,new UserRowMapper(),user.getUserName(),user.getUserPassword());
            return l;  
        }catch(Exception e) {
            return null;
        }
    }
}
