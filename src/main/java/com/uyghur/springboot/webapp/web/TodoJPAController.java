package com.uyghur.springboot.webapp.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.uyghur.springboot.webapp.exception.TodoNotFoundException;
import com.uyghur.springboot.webapp.model.Todo;
import com.uyghur.springboot.webapp.repository.TodoRepository;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoJPAController {
	
	private TodoRepository todoRepository;
	
	public TodoJPAController(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("list-todos")
	public String todoAllList(ModelMap model) {
		
		String username = getLoggedinUsername(model);
		
		List<Todo> todos = todoRepository.findByUsername(username);
		
		model.addAttribute("todos", todos);
		
		return "listTodo";
	}
	

	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedinUsername(model);
		Todo todo = new Todo(username, "Default Description", LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(
			ModelMap model,
			@Valid Todo todo,
			BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedinUsername(model);
		todo.setUsername(username);
		
		todoRepository.save(todo);
		
		return "redirect:list-todos";
	}
	

	@RequestMapping(value="delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(
			ModelMap model, @RequestParam int id) throws TodoNotFoundException {
		Todo todo = todoRepository.findById(id).
				orElseThrow(() -> new TodoNotFoundException("Todo with this id: " + id + " not found in DB!"));
		
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(
			ModelMap model, 
			@Valid Todo todo,
			BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedinUsername(model);
		todo.setUsername(username);
		
		todoRepository.save(todo);
		
		return "redirect:list-todos";
	}
	private String getLoggedinUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	
	
}
