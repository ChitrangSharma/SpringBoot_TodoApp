package com.geek24.todo_app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequestDTO {
    @NotBlank(message="Title can not be empty")
    private String title;
    private String description;
    private Boolean completed;
}
