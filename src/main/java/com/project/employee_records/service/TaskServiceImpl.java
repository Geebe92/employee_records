package com.project.employee_records.service;

import com.project.employee_records.model.Task;
import com.project.employee_records.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    @Override
    public Optional<Task> getTask(Integer idTask) {
        return taskRepository.findById(idTask);
    }

    @Override
    public Page<Task> getTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public Task setTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public void deleteTask(Integer idTask) {
        taskRepository.deleteById(idTask);
    }
}
