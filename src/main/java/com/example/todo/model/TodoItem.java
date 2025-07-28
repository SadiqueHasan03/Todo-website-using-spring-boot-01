package com.example.todo.model;

public class TodoItem {

    private String task;
    private boolean completed;

    public TodoItem(){}

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodoItem(String task){
        this.task = task;
        this.completed = false;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
