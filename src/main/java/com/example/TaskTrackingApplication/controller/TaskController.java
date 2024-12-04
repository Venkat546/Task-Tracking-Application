package com.example.TaskTrackingApplication.controller;

import com.example.TaskTrackingApplication.dto.TaskDTO;
import com.example.TaskTrackingApplication.service.TaskService;

import com.example.TaskTrackingApplication.model.Task;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Get task by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    // Create a new task
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        Task createdTask = taskService.createTask(mapToEntity(taskDTO));
        return ResponseEntity.status(201).body(createdTask);
    }

    // Update an existing task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDTO taskDTO) {
        Task updatedTask = taskService.updateTask(id, mapToEntity(taskDTO));
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);

        // Prepare custom response message
        Map<String, String> response = new HashMap<>();
        response.put("message", "Task with ID " + id + " was deleted successfully");

        return ResponseEntity.ok(response);
    }


    // Mark a task as complete
    @PatchMapping("/{id}/complete")
    public ResponseEntity<Task> markTaskAsComplete(@PathVariable Long id) {
        Task updatedTask = taskService.markTaskAsComplete(id);
        return ResponseEntity.ok(updatedTask);
    }

    // Helper method to map TaskDTO to Task entity
    private Task mapToEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setStatus(Task.Status.valueOf(taskDTO.getStatus().toUpperCase()));
        return task;
    }
}
