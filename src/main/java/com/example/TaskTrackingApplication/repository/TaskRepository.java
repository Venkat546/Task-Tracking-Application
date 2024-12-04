package com.example.TaskTrackingApplication.repository;


import com.example.TaskTrackingApplication.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}