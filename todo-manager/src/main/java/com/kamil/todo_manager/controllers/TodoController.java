package com.kamil.todo_manager.controllers;

import com.kamil.todo_manager.entity.Todo;
import com.kamil.todo_manager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {
    Random random=new Random();
    Logger logger= LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoService todoService;
    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){
        int id= random.nextInt(999999);
        todo.setId(id);
        logger.info("Todo created");
        Todo todo1=todoService.createTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);

    }
}
