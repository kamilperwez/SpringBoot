package com.kamil.todo_manager.dao;

import com.kamil.todo_manager.entity.Todo;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDao {
    @Autowired
    private JdbcTemplate template;
    Logger logger= LoggerFactory.getLogger(TodoDao.class);
    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public TodoDao(@Autowired JdbcTemplate template) {
        this.template = template;
        String createTable="create table if not exists todos (id int primary key, title varchar(30), content varchar(300), status varchar(15))";
        template.update(createTable);
        logger.info("Table created");
    }
    public void save(Todo todo){
        String query="insert into todos values (?,?,?,?)";
        int n= template.update(query,todo.getId(),todo.getTitle(),todo.getContent(),todo.getStatus());
        logger.info("Row Inserted");
    }
    public List<Todo> getAll(){
        String query="select * from todos";
        List<Todo> todos=template.query(query,new TodoRowMapper());
        return todos;
    }

}
