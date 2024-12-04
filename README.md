# Task Tracking Application  

## Introduction  

The Task Tracking Application is a Spring Boot-based microservice designed to manage tasks. It allows users to create, read, update, delete, and mark tasks as complete. This system is designed to manage tasks dynamically and efficiently, making it suitable for task management applications.  

## Technologies Used    

The project is built using the following technologies:    
- **Java 23**: The latest version of Java, providing modern language features and enhancements.    
- **Spring Boot 3.4.0**: A powerful framework for building microservices and REST APIs.    
- **Spring Data JPA**: Used for data access and persistence with the H2 in-memory database.    
- **H2 Database**: A lightweight, in-memory database used for rapid testing and development.    
- **Maven**: Dependency management and build tool used for packaging the application.  

## Setup Instructions        

### 1. Clone the Repository      
Clone the project repository from GitHub using the following command:        

        bash``` 
            git clone https://github.com/Venkat546/Task-Tracking-Application.git    
            cd Task-Tracking-Application    
            ```

### 2. Build the Application    
 Use Maven to clean and build the project:    
       ```mvn clean install  
     ```

### 3. Run the Application    
Start the Spring Boot application using Maven:    
        
        mvn spring-boot:run  
        ```
**Once the application is running, it will be accessible at http://localhost:8080.**  

### 4. Access the H2 Database  
The application uses an in-memory H2 database, which can be accessed via the H2 console at:  
```
    URL: http://localhost:8080/h2-console
    JDBC URL: jdbc:h2:mem:testdb
    Username: sa
    Password: password
```

## Dependencies  

All necessary dependencies are already included in the project's pom.xml file. You do not need to manually add them; Maven will automatically download and manage these dependencies when you build the project. These dependencies include:  

-Spring Boot Starter Data JPA: Manages data persistence using JPA.  
-H2 Database: An in-memory database used for testing.  
-Spring Boot Starter Test: Provides tools for writing unit and integration tests.  
-Spring Boot Starter Web: Provides REST API functionality.  
-Just ensure that Maven is installed and properly set up on your system, and then you can build and run the project as described in the instructions.  

## API Endpoints  

The application provides the following REST API endpoints for creating, reading, updating, deleting, and completing tasks:  

Method	Endpoint	Description  
POST	/tasks	Creates a new task  
GET	/tasks	Retrieves all tasks  
GET	/tasks/{id}	Retrieves a task by its ID  
PUT	/tasks/{id}	Updates an existing task  
DELETE	/tasks/{id}	Deletes a task  
PATCH	/tasks/{id}/complete	Marks a task as completed    


## Testing the API  

You can test the REST API endpoints using Postman by following these steps:  

-Open Postman and create a new request.  
-Set the HTTP method (e.g., POST or GET).  
-Enter the endpoint URL (e.g., http://localhost:8080/tasks).  
-For POST requests, set the request body in JSON format.  
-Send the request and check the response in the Postman interface.  


### Request and Response  

### 1. Create a Task  
##### Request:  

{
  "title": "Task Title",
  "description": "Task Description",
  "dueDate": "YYYY-MM-DD",
  "status": "PENDING"
}  


#### Response:  

{
  "id": 1,
  "title": "Task Title",
  "description": "Task Description",
  "dueDate": "YYYY-MM-DD",
  "status": "PENDING"
}  


### 2. Get All Tasks  
#### Request:  

            GET /tasks

#### Response:  

[
  {
    "id": 1,
    "title": "Task Title",
    "description": "Task Description",
    "dueDate": "YYYY-MM-DD",
    "status": "PENDING"
  },  
  {
    "id": 2,
    "title": "Another Task",
    "description": "Another Description",
    "dueDate": "YYYY-MM-DD",
    "status": "IN_PROGRESS"
  }
]  

### 3. Get Task by ID  
#### Request:  

GET /tasks/{id}

#### Example:

GET /tasks/1  

#### Response:  

{
  "id": 1,
  "title": "Task Title",
  "description": "Task Description",
  "dueDate": "YYYY-MM-DD",
  "status": "PENDING"
}  

### 4. Update a Task  
#### Request:  

{
  "title": "Updated Task Title",
  "description": "Updated Description",
  "dueDate": "YYYY-MM-DD",
  "status": "IN_PROGRESS"
}  
#### Response:  

{
  "id": 1,
  "title": "Updated Task Title",
  "description": "Updated Description",
  "dueDate": "YYYY-MM-DD",
  "status": "IN_PROGRESS"
}  
### 5. Delete a Task  
#### Request:  

DELETE /tasks/{id}

#### Example:  

DELETE /tasks/1  

### Response:  

{
  "message": "Task deleted successfully"
}  
### 6. Mark Task as Complete  
#### Request:  

PATCH ```/tasks/{id}/complete```

#### Example:    

PATCH ```/tasks/1/complete```

### Response:  

{
  "id": 1,
  "title": "Task Title",
  "description": "Task Description",
  "dueDate": "YYYY-MM-DD",
  "status": "COMPLETED"
}  
## Conclusion  

The Task Tracking Application is a robust system designed for managing tasks dynamically. It provides CRUD functionality for tasks and enables task completion status updates. The system is built using Spring Boot, with an in-memory H2 database for fast development and testing. Future improvements could include more advanced features such as authentication, pagination, and task prioritization.
