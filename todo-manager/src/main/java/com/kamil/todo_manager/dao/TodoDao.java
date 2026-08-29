package com.kamil.todo_manager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TodoDao {
    @Autowired
    private JdbcTemplate template;
}
