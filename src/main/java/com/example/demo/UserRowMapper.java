package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.User;

public class UserRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User u = new User();
        u.setUserId(rs.getInt(1));
        u.setUserName(rs.getString(2));
        u.setUserGmail(rs.getString(3));
        u.setUserPassword(rs.getString(4));
        u.setPhoneNo(rs.getLong(5));
        return u;
    }
    
    
}
