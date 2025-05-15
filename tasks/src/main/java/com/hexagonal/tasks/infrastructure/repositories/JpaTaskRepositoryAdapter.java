package com.hexagonal.tasks.infrastructure.repositories;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {
    @Autowired
    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }


    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id)
                .map(TaskEntity::toDomainModel);
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        var savedEntity = jpaTaskRepository.save(taskEntity);
        return savedEntity.toDomainModel();
    }

    @Override
    public void delete(Long id) {
        if (!jpaTaskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task with id " + id + " does not exist");
        }
        jpaTaskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll()
                .stream()
                .map(TaskEntity::toDomainModel)
                .toList();
    }

    @Override
    public Task update(Long id, Task task) {
        if (!jpaTaskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task with id " + id + " does not exist");
        }
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        var updatedEntity = jpaTaskRepository.save(taskEntity);
        return updatedEntity.toDomainModel();
    }
}
