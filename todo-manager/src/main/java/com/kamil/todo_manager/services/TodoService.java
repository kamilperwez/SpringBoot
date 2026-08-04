package com.kamil.todo_manager.services;

import com.kamil.todo_manager.entity.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
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
    public List<Todo> getAllTodos(){
        return todos;
    }
    public Todo getTodoById(int id){
        Todo todo1=todos.stream().filter(t->id==t.getId()).findAny().get();
        logger.info("Returning TODO {}",todo1);
        return todo1;
    }
    public Todo updateTodo(int id,Todo todo){
        for(Todo t:todos){
            if(t.getId()==id){
                t.setTitle(todo.getTitle());
                t.setStatus(todo.getStatus());
                t.setContent(todo.getContent());
                return t;
            }
        }
        return null;
    }
}
