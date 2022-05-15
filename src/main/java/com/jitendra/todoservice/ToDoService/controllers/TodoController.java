package com.jitendra.todoservice.ToDoService.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jitendra.todoservice.ToDoService.exceptions.UserException;
import com.jitendra.todoservice.ToDoService.todo.ToDoRepository;
import com.jitendra.todoservice.ToDoService.todo.Todo;
import com.jitendra.todoservice.ToDoService.user.User;
import com.jitendra.todoservice.ToDoService.user.UserRepository;

@RestController
public class TodoController {
	
	@Autowired
	ToDoRepository todoRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(path = "/users/{id}/todos")
	public List<Todo> getAllTodo(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
			throw new UserException.UserNotFoundException("User with id: "+id);
		return user.get().getTodos();
	}
	
	@PostMapping(path = "/users/{id}/todos")
	public ResponseEntity<Object> saveTodo(@PathVariable int id,@RequestBody Todo todo){
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
			throw new UserException.UserNotFoundException("User with id: "+id);
		todo.setUser(user.get());
		todoRepository.save(todo);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(todo.getId());
		return ResponseEntity.created(location).build();
	}
}
