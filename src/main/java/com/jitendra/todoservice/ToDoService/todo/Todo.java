package com.jitendra.todoservice.ToDoService.todo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jitendra.todoservice.ToDoService.user.User;

@Entity
public class Todo {
	@javax.persistence.Id
	@GeneratedValue
	private Integer Id;
	private Date createdAt;
	private Date completionDate;
	private String title;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	public Todo(Date createdAt, Date completionDate, String title, String description) {
		super();
		this.createdAt = createdAt;
		this.completionDate = completionDate;
		this.title = title;
		this.description = description;
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Todo [createdAt=" + createdAt + ", completionDate=" + completionDate + ", title=" + title
				+ ", description=" + description + "]";
	}
}
