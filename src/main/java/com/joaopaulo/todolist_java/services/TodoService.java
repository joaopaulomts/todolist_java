package com.joaopaulo.todolist_java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.joaopaulo.todolist_java.dtos.TodoRequestDto;
import com.joaopaulo.todolist_java.dtos.TodoResponseDto;
import com.joaopaulo.todolist_java.mappers.TodoMapper;
import com.joaopaulo.todolist_java.models.TodoEntity;
import com.joaopaulo.todolist_java.repositories.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoResponseDto save(TodoRequestDto todoRequestDto){
        return todoMapper.toDto(todoRepository.save(todoMapper.toEntity(todoRequestDto)));
    }

    public List<TodoResponseDto> getAll() {
        return todoRepository.findAll().stream().map(todoMapper::toDto).toList();
    }

    public TodoResponseDto getById(Long id) {
        TodoEntity todo = checkId(id);
        return todoMapper.toDto(todo);
    }

    public TodoResponseDto delete(Long id) {
        TodoEntity todo = checkId(id);
        todoRepository.delete(todo);
        return todoMapper.toDto(todo);
    }

    public TodoResponseDto update(Long id, TodoRequestDto todoRequestDto) {
        checkId(id);
        TodoEntity todoEntity = todoMapper.toEntity(todoRequestDto);
        todoEntity.setId(id);
        return todoMapper.toDto(todoRepository.save(todoEntity));
    }

    public TodoResponseDto completed(Long id) {
        TodoEntity todo = checkId(id);
        todo.setCompleted(true);
        return todoMapper.toDto(todoRepository.save(todo));
    }

    public TodoEntity checkId(Long id) {
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(todo.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        return todo.get();
    }
}
