package com.example.listoftasks.model;

import java.io.Serializable;

public class BeanTask implements Serializable {

    private String id;
    private String task;

    public String getId() {
        return id;
    }

    public BeanTask setId(String id) {
        this.id = id;
        return this;
    }

    public String getTask() {
        return task;
    }

    public BeanTask setTask(String task) {
        this.task = task;
        return this;
    }
}
