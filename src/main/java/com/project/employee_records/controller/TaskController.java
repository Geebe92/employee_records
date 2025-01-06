package com.project.employee_records.controller;

import com.project.employee_records.model.Task;
import com.project.employee_records.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks/{idTask}")
    public ResponseEntity<Task> getTask(@PathVariable Integer idTask){
        return ResponseEntity.of(taskService.getTask(idTask));
    }

    @GetMapping("/tasks")
    public Page<Task> getTasks(Pageable pageable){
        return taskService.getTasks(pageable);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Void> saveTask(@RequestBody Task task){
        Task createTask = taskService.setTask(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idTask}").buildAndExpand(createTask.getIdTask()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        headers.add("Access-Control-Expose-Headers", "*");
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/tasks/{idTask}")
    public ResponseEntity<Void> updateTask(@RequestBody Task task, @PathVariable Integer idTask){
        return taskService.getTask(idTask)
                .map(t -> {
                    taskService.setTask(task);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/tasks/{idTask}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer idTask){
        return taskService.getTask(idTask)
                .map(t -> {
                    taskService.deleteTask(idTask);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
