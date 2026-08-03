package com.kamil.todo_manager.services;

import com.kamil.todo_manager.entity.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TodoService {


    List<Todo> todos=new ArrayList<>();
    Logger logger= LoggerFactory.getLogger((TodoService.class));
    public Todo createTodo(Todo todo){

        todos.add(todo);
        logger.info("Todos {} ",this.todos);
        return todo;
    }
}
