package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "is required")
    private String name;
    @NotEmpty(message = "is required")
    private String description;
    @NotEmpty(message = "is required")
    private String priority;
    @NotEmpty(message = "is required")
    private String date;
    private boolean is_completed;


    public ToDoList(){
    }

    public ToDoList(@NotEmpty(message = "is required") String name, @NotEmpty(message = "is required")
            String description, @NotEmpty(message = "is required") String priority, @NotEmpty(message = "is required")
            String date, boolean is_completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.date = date;
        this.is_completed = is_completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }
}
