package com.kamil.todo_manager.controllers;

import com.kamil.todo_manager.entity.Todo;
import com.kamil.todo_manager.services.TodoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {
    Random random=new Random();
    Logger logger= LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoServices todoService;
    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){
        int id= random.nextInt(999999);
        todo.setId(id);
        Date date=new Date();
        logger.info("Todo created");
        logger.info(" Todo Date {} ",date);
        todoService.save(todo);
        logger.info(" Todo Date created {} ",todo.getTodoDate());
        return new ResponseEntity<>(todo, HttpStatus.CREATED);

    }
    @GetMapping
    public  ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todos=todoService.getAll();
        return new ResponseEntity<>(todos,HttpStatus.OK);
    }
    /*
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") int id){
        Todo todo1=todoService.getTodoById(id);
        return new ResponseEntity<>(todo1,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo newTodo,@PathVariable("id") int id){
        todoService.updateTodo(id,newTodo);
        return new ResponseEntity<>(newTodo,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable int id){
        Todo todo1=todoService.deleteTodo(id);
        logger.info("Todo deleted {} ",todo1);
        return new ResponseEntity<>(todo1,HttpStatus.OK);
    }*/
}
