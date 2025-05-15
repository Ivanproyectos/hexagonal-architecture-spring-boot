package com.hexagonal.tasks.domain.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean completed;

    public Task(Long id, String title, String description, LocalDateTime createAt, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createAt;
        this.completed = completed;
    }

}
