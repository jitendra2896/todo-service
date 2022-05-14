package com.jitendra.todoservice.ToDoService.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jitendra.todoservice.ToDoService.user.User;
import com.jitendra.todoservice.ToDoService.user.UserAlreadyRegisteredException;
import com.jitendra.todoservice.ToDoService.user.UserRepository;

@RestController
public class UserConroller {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User alreadyExistingUser = userRepository.findByEmail(user.getEmail());
		if(alreadyExistingUser != null)
			throw new UserAlreadyRegisteredException("email - "+user.getEmail());
		
		User createdUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(createdUser.getId());
		return ResponseEntity.created(location).build();
	}
}
