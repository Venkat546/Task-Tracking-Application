# Task Tracking Application

This is a Spring Boot-based Task Tracking application, where you can manage tasks, including creating, reading, updating, deleting, and marking tasks as completed. The application uses H2 in-memory database for data storage.

## Features

- **Create** a new task
- **Get** all tasks or a specific task by ID
- **Update** an existing task
- **Delete** a task
- **Mark** a task as complete

## Technologies Used

- Java 23
- Spring Boot 3.4.0
- Spring Data JPA
- H2 Database (in-memory)
- Lombok
- Spring Boot Validation
- JUnit 5 & Mockito for Unit Testing

## Installation

1. Clone the repository:
    ```bash
    git clone <repository-url>
    cd TaskTrackingApplication
    ```

2. Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse).

3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Endpoints

### 1. Get All Tasks

- **URL**: `/tasks`
- **Method**: `GET`
- **Response**: A list of all tasks.

### 2. Get Task by ID

- **URL**: `/tasks/{id}`
- **Method**: `GET`
- **Response**: The task with the given ID.

### 3. Create Task

- **URL**: `/tasks`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
      "title": "Task Title",
      "description": "Task Description",
      "dueDate": "YYYY-MM-DD",
      "status": "PENDING"
    }
    ```
- **Response**: The created task.

### 4. Update Task

- **URL**: `/tasks/{id}`
- **Method**: `PUT`
- **Request Body**:
    ```json
    {
      "title": "Updated Task Title",
      "description": "Updated Description",
      "dueDate": "YYYY-MM-DD",
      "status": "IN_PROGRESS"
    }
    ```
- **Response**: The updated task.

### 5. Delete Task

- **URL**: `/tasks/{id}`
- **Method**: `DELETE`
- **Response**: A message indicating the task was deleted successfully.

### 6. Mark Task as Complete

- **URL**: `/tasks/{id}/complete`
- **Method**: `PATCH`
- **Response**: The task with status "COMPLETED".

## Database Configuration

The application uses an in-memory H2 database for data storage, configured as follows:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
