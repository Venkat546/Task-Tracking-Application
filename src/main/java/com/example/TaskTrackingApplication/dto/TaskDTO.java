package com.example.TaskTrackingApplication.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TaskDTO {

    @NotNull(message = "Title is required")
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotNull(message = "Description is required")
    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;

    @NotNull(message = "Status is required")
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;

        TaskDTO taskDTO = (TaskDTO) o;

        if (!title.equals(taskDTO.title)) return false;
        if (!description.equals(taskDTO.description)) return false;
        if (!dueDate.equals(taskDTO.dueDate)) return false;
        return status.equals(taskDTO.status);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + dueDate.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                '}';
    }
}