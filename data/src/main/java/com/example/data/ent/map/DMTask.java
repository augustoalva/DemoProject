package com.example.data.ent.map;

import com.example.data.ent.EntTask;
import com.example.domain.Task;

import java.util.ArrayList;
import java.util.List;

public class DMTask {

    public Task transform(EntTask poEntTask) {
        Task loTask = null;
        if (poEntTask != null) {
            loTask = new Task();
            loTask.setId(poEntTask.getId())
                    .setTask(poEntTask.getTask());
        }
        return loTask;
    }

    public List<Task> transform(List<EntTask> paEntTasks) {
        List<Task> laTasks = new ArrayList<>();
        if (paEntTasks != null) {
            for (EntTask loEntTask : paEntTasks) {
                laTasks.add(transform(loEntTask));
            }
        }
        return laTasks;
    }

    public EntTask transformEnt(Task poTask) {
        EntTask loEntTask = null;
        if (poTask != null) {
            loEntTask = new EntTask();
            loEntTask.setId(poTask.getId())
                    .setTask(poTask.getTask());
        }
        return loEntTask;
    }

    public List<EntTask> transformListEnt(List<Task> paTasks) {
        List<EntTask> laEntTasks = new ArrayList<>();
        if (paTasks != null) {
            for (Task loTask : paTasks) {
                laEntTasks.add(transformEnt(loTask));
            }
        }
        return laEntTasks;
    }
}
