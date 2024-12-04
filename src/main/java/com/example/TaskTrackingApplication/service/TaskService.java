package com.example.TaskTrackingApplication.service;


import com.example.TaskTrackingApplication.exception.TaskNotFoundException;

import com.example.TaskTrackingApplication.model.Task;

import com.example.TaskTrackingApplication.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setDueDate(updatedTask.getDueDate());
                    task.setStatus(updatedTask.getStatus());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task with ID " + id + " not found");
        }
        taskRepository.deleteById(id);
    }


    public Task markTaskAsComplete(Long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setStatus(Task.Status.COMPLETED);
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));
    }
}