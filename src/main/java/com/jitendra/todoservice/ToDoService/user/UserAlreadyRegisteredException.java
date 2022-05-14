package com.jitendra.todoservice.ToDoService.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyRegisteredException extends RuntimeException {
	public UserAlreadyRegisteredException(String message) {
		super(message);
	}
}
