package com.l3.gl.model;

import java.time.LocalDateTime;

public class Task {
    private String description;
    private boolean done;
    private LocalDateTime dateTime;

    public Task(String description) {
        this.description = description;
        this.done = false;
        this.dateTime = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDone(boolean done) {
        this.done = done;
        this.dateTime = LocalDateTime.now();
    }
}