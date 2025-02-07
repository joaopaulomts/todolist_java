package com.joaopaulo.todolist_java.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaopaulo.todolist_java.dtos.TodoRequestDto;
import com.joaopaulo.todolist_java.dtos.TodoResponseDto;
import com.joaopaulo.todolist_java.services.TodoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;
    
    @PostMapping
    public TodoResponseDto save(@RequestBody @Valid TodoRequestDto todoRequestDto) {
        return todoService.save(todoRequestDto);
    }

    @GetMapping
    public List<TodoResponseDto> getAll() {
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public TodoResponseDto getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public TodoResponseDto delete(@PathVariable Long id) {
        return todoService.delete(id);
    }
    
    @PutMapping("/{id}")
    public TodoResponseDto update(@PathVariable Long id, @RequestBody @Valid TodoRequestDto todoRequestDto) {
        return todoService.update(id, todoRequestDto);
    }

    @GetMapping("/completed/{id}")
    public TodoResponseDto completed(@PathVariable Long id) {
        return todoService.completed(id);
    }
}
