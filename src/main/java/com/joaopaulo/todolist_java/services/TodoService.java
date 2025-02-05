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
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(todo.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        return todoMapper.toDto(todo.get());
    }

    public TodoResponseDto delete(Long id) {
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(todo.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        todoRepository.delete(todo.get());
        return todoMapper.toDto(todo.get());
    }

    public TodoResponseDto update(Long id, TodoRequestDto todoRequestDto) {
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(todo.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        TodoEntity todoEntity = todoMapper.toEntity(todoRequestDto);
        todoEntity.setId(id);
        return todoMapper.toDto(todoRepository.save(todoEntity));
    }
}
