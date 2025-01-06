package com.project.employee_records.service;

import com.project.employee_records.model.Record;
import com.project.employee_records.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskService {
    Optional<Task> getTask(Integer idTask);
    Page<Task> getTasks(Pageable pageable);
    Task setTask(Task task);
    void deleteTask(Integer idTask);
}
