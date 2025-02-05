package com.joaopaulo.todolist_java.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoRequestDto(
    @NotBlank(message = "O campo nome não pode estar em branco.")
    String name,
    @NotBlank(message = "O campo descrição não pode estar em branco.")
    String description,
    @NotNull(message = "Data limite não pode ser nula.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate deadline
) {
    
}
