package com.joaopaulo.todolist_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaopaulo.todolist_java.models.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity,Long> {
    
}
