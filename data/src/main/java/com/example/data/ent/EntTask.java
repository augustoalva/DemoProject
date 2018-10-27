package com.example.data.ent;

import java.io.Serializable;

public class EntTask implements Serializable {

    private String id;
    private String task;

    public String getId() {
        return id;
    }

    public EntTask setId(String id) {
        this.id = id;
        return this;
    }

    public String getTask() {
        return task;
    }

    public EntTask setTask(String task) {
        this.task = task;
        return this;
    }
}
