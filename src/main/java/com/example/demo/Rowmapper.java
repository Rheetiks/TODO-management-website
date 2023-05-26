package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.tasks;

public class Rowmapper implements RowMapper<tasks>{

    @Override
    public tasks mapRow(ResultSet rs, int rowNum) throws SQLException {
        tasks t= new tasks();
        t.setTaskId(rs.getInt(1));
        t.setUserId(rs.getInt(2));
        t.setTaskName(rs.getString(3));
        return t;
    }
    
}
