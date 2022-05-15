package com.jitendra.todoservice.ToDoService.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, Integer>{

}
