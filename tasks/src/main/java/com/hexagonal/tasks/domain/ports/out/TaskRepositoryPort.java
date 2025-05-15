package com.hexagonal.tasks.domain.ports.out;

import com.hexagonal.tasks.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Optional<Task> findById(Long id);

    Task save(Task task);

    void delete(Long id);

    List<Task> findAll();

    Task update(Long id, Task task);
}
