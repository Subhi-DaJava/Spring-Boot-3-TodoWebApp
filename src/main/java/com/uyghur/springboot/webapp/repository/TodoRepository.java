package com.uyghur.springboot.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uyghur.springboot.webapp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>  {
	public List<Todo> findByUsername(String username);

}
