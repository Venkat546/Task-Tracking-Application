package com.example.TaskTrackingApplication;

import com.example.TaskTrackingApplication.controller.TaskController;
import com.example.TaskTrackingApplication.model.Task;
import com.example.TaskTrackingApplication.service.TaskService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TaskTrackingApplicationTests {

	@Mock
	private TaskService taskService;

	@InjectMocks
	private TaskController taskController;

	public TaskTrackingApplicationTests() {
		MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void afterEach() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetTaskById() {
		// Arrange
		Long taskId = 1L;
		Task mockTask = new Task();
		mockTask.setId(taskId);
		mockTask.setTitle("Test Task");
		mockTask.setDescription("Test Description");
		mockTask.setDueDate(LocalDate.now());
		mockTask.setStatus(Task.Status.PENDING);

		when(taskService.getTaskById(taskId)).thenReturn(mockTask);

		// Act
		ResponseEntity<Task> response = taskController.getTaskById(taskId);

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockTask, response.getBody());
		verify(taskService, times(1)).getTaskById(taskId);
	}

	@Test
	void testCreateTask() {
		// Arrange
		Task taskToCreate = new Task();
		taskToCreate.setTitle("New Task");
		taskToCreate.setDescription("New Description");
		taskToCreate.setDueDate(LocalDate.now());
		taskToCreate.setStatus(Task.Status.PENDING);

		when(taskService.createTask(taskToCreate)).thenReturn(taskToCreate);

		// Act
		Task createdTask = taskService.createTask(taskToCreate);

		// Assert
		assertEquals("New Task", createdTask.getTitle());
		assertEquals("New Description", createdTask.getDescription());
		verify(taskService, times(1)).createTask(taskToCreate);
	}
}
