package com.hexagonal.tasks.infrastructure.entities;

import com.hexagonal.tasks.domain.models.Task;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 50)
    private String description;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    private boolean completed;

    public TaskEntity() {
    }

    public TaskEntity(String title, String description, LocalDateTime createdAt, boolean completed) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.completed = completed;
    }

    public static TaskEntity fromDomainModel(Task task) {
        return new TaskEntity(
                task.getTitle(),
                task.getDescription(),
                task.getCreatedAt(),
                task.isCompleted()
        );
    }

    public Task toDomainModel() {
        return new Task(
                id,
                title,
                description,
                createdAt,
                completed
        );
    }

}
