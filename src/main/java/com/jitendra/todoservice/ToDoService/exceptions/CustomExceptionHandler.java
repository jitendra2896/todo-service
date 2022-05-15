package com.jitendra.todoservice.ToDoService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jitendra.todoservice.ToDoService.exceptions.UserException.UserAlreadyRegisteredException;
import com.jitendra.todoservice.ToDoService.exceptions.UserException.UserNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request){
		System.out.println("Inside handle all");
		ExceptionResponse res = new ExceptionResponse("Internal Server Error",ex.getMessage());
		return new ResponseEntity<Object>(res,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex,WebRequest request){
		System.out.println("Inside specific");
		ResponseEntity<Object> entity = null;
		ExceptionResponse res = null;
		if(ex instanceof UserAlreadyRegisteredException) {
			res = new ExceptionResponse("User Already Registered", ex.getMessage());
			entity = new ResponseEntity<Object>(res,HttpStatus.CONFLICT);
		}
		else if(ex instanceof UserNotFoundException) {
			res = new ExceptionResponse("User Not Found", ex.getMessage());
			entity = new ResponseEntity<Object>(res,HttpStatus.NOT_FOUND);
		}
		else {
			res = new ExceptionResponse("Internal Server Error", ex.getMessage());
			entity = new ResponseEntity<Object>(res,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
}
