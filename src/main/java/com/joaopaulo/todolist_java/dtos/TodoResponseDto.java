package com.joaopaulo.todolist_java.dtos;

import java.sql.Timestamp;
import java.time.LocalDate;

public record TodoResponseDto(
    Long id,
    String name,
    String description,
    LocalDate deadline,
    Timestamp createdAt
){
    
}
