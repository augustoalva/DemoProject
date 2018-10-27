package com.example.domain;

import java.io.Serializable;

public class Task implements Serializable {

    private String id;
    private String task;

    public String getId() {
        return id;
    }

    public Task setId(String id) {
        this.id = id;
        return this;
    }

    public String getTask() {
        return task;
    }

    public Task setTask(String task) {
        this.task = task;
        return this;
    }
}
