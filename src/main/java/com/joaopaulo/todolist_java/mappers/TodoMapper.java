package com.joaopaulo.todolist_java.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.joaopaulo.todolist_java.dtos.TodoRequestDto;
import com.joaopaulo.todolist_java.dtos.TodoResponseDto;
import com.joaopaulo.todolist_java.models.TodoEntity;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoResponseDto toDto(TodoEntity todoEntity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "completed", ignore = true)
    TodoEntity toEntity(TodoRequestDto todoRequestDto);
}
