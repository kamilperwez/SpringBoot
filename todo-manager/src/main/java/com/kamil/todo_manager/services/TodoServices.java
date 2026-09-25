package com.kamil.todo_manager.services;

import com.kamil.todo_manager.entity.Todo;

import java.util.List;

public interface TodoServices {
    public void save(Todo todo);
    public List<Todo> getAll();
}
