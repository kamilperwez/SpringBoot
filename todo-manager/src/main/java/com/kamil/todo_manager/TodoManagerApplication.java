package com.kamil.todo_manager;

import com.kamil.todo_manager.dao.TodoDao;
import com.kamil.todo_manager.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {
	@Autowired
	private TodoDao todoDao;

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
