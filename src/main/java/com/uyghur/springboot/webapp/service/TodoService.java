package com.uyghur.springboot.webapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.uyghur.springboot.webapp.model.Todo;

@Service
public class TodoService {
	private static final Logger logger = LoggerFactory.getLogger(TodoService.class);
	
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
	static {
		todos.add(new Todo(++todosCount, "uyghurJava", "Learn AWS",
				LocalDate.now().plusYears(1), false));
		
		todos.add(new Todo(++todosCount, "uyghurJava", "Dev Web",
				LocalDate.now().plusYears(2), false));
		
		todos.add(new Todo(++todosCount, "uyghurJava", "Dev Java",
				LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username) {
		logger.info("List todos is loading successfully from TodoService!");
		return todos;
	}
	
	public void addTodo(
			String username,
			String description,
			LocalDate targetDate,
			boolean done) {
		Todo newTodo = new Todo(
				++todosCount,
				username, 
				description,
				targetDate, 
				done);
		
		todos.add(newTodo);
	}
	
	public void deleteById(int id) {
		//todo.getId() == id
		// todo -> todo.getId() == id
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		
		todos.removeIf(predicate);
	}
	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
}
