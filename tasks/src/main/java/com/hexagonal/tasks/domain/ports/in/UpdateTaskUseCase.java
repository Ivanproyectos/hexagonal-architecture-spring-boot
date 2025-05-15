package com.hexagonal.tasks.domain.ports.in;

import com.hexagonal.tasks.domain.models.Task;

public interface UpdateTaskUseCase {
    Task updateTask(long id, Task updatedTask);
}
