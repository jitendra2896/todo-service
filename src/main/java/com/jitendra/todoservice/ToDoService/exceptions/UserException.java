package com.jitendra.todoservice.ToDoService.exceptions;

public class UserException extends RuntimeException {
	public UserException(String message) {
		super(message);
	}
	
	public static class UserNotFoundException extends UserException{

		public UserNotFoundException(String message) {
			super(message);
		}
	}
	
	public static class UserAlreadyRegisteredException extends UserException{

		public UserAlreadyRegisteredException(String message) {
			super(message);
		}
	}
}