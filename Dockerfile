# Use the official OpenJDK image as the base image
FROM openjdk:23-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar file into the container
COPY target/TaskTrackingApplication-0.0.1-SNAPSHOT.jar /app/tasktrackingapp.jar

# Expose the port your Spring Boot application is running on (8080 by default)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "tasktrackingapp.jar"]
