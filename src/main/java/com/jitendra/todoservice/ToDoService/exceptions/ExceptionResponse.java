package com.jitendra.todoservice.ToDoService.exceptions;

public class ExceptionResponse {
	private String detail;
	private String message;
	
	public ExceptionResponse(String detail, String message) {
		super();
		this.detail = detail;
		this.message = message;
	}
	
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
