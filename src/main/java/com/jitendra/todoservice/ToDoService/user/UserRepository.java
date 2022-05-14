package com.jitendra.todoservice.ToDoService.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
}
