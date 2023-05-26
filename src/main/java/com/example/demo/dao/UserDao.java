package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.UserRowMapper;
import com.example.demo.model.User;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbc;


    public List<User> viewUser(){
        String q="select * from user";
        List <User> l=this.jdbc.query(q, new UserRowMapper());
        return l;
    }
    public User addUser(User user){
        User check=new User();
        String q="select * from user where username=? && password=?";
        try{
            check =this.jdbc.queryForObject(q,new UserRowMapper(),user.getUserName(),user.getUserPassword());
            if(check.getUserId()>0){
                return check;
            }
        }catch(Exception e){}

        q= "insert into user (username,gmail,password,phone_no) values (?,?,?,?)";
        this.jdbc.update(q,user.getUserName(),user.getUserGmail(),user.getUserPassword(),user.getPhoneNo());
        q="select * from user where username=? && password=?";
        return this.jdbc.queryForObject(q,new UserRowMapper(),user.getUserName(),user.getUserPassword());
        
    }
    public User logIn(User user){
        User u = new User();
        try{
            String q="select * from user where username=? && password=?";
            u=this.jdbc.queryForObject(q,new UserRowMapper(),user.getUserName(),user.getUserPassword());
            if(u.getUserId()==0){
                u.setResult("failure");
            }else{
                u.setResult("success");
            }
        } catch(Exception e){}
        return u;
    }
}
