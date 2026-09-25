package com.kamil.todo_manager.dao;

import com.kamil.todo_manager.entity.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<Todo> {

    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo=new Todo();
        todo.setId((int)rs.getInt("id"));
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setStatus(rs.getString("status"));
        return todo;
    }
}
