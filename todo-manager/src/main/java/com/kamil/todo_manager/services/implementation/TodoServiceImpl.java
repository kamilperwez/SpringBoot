package com.kamil.todo_manager.services.implementation;

import com.kamil.todo_manager.dao.TodoDao;
import com.kamil.todo_manager.entity.Todo;
import com.kamil.todo_manager.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoServices {
    @Autowired
    TodoDao todoDao;
    @Override
    public void save(Todo todo) {
        todoDao.save(todo);
    }

    @Override
    public List<Todo> getAll() {
        return todoDao.getAll();
    }
}
