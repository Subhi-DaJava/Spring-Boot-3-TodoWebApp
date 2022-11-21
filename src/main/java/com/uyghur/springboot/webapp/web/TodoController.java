package com.uyghur.springboot.webapp.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.uyghur.springboot.webapp.model.Todo;
import com.uyghur.springboot.webapp.service.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String todoAllList(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("uyghurJava");
		
		model.addAttribute("todos", todos);
		
		return "listTodo";
	}
	

	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "Default Description", LocalDate.now().plusYears(1), false);
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
		String username = (String)model.get("name");
		
		todoService.addTodo(username, todo.getDescription() ,LocalDate.now().plusYears(1), false);
		
		return "redirect:list-todos";
	}
}
