package com.example.listoftasks.model.map;

import com.example.domain.Task;
import com.example.listoftasks.model.BeanTask;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MapTask {

    @Inject
    public MapTask() {

    }

    public Task transform(BeanTask poBeanTask) {
        Task loTask = null;
        if (poBeanTask != null) {
            loTask = new Task();
            loTask.setId(poBeanTask.getId())
                    .setTask(poBeanTask.getTask());
        }
        return loTask;
    }

    public BeanTask transformBean(Task poTask) {
        BeanTask loBeanTask = null;
        if (poTask != null) {
            loBeanTask = new BeanTask();
            loBeanTask.setId(poTask.getId())
                    .setTask(poTask.getTask());
        }
        return loBeanTask;
    }

    public List<Task> transform(List<BeanTask> paBeanTasks) {
        List<Task> laTasks = new ArrayList<>();
        if (paBeanTasks != null) {
            for (BeanTask loBeanTask : paBeanTasks) {
                laTasks.add(transform(loBeanTask));
            }
        }
        return laTasks;
    }

    public List<BeanTask> transformBean(List<Task> paTasks) {
        List<BeanTask> laBeanTasks = new ArrayList<>();
        if (paTasks != null) {
            for (Task loTask : paTasks) {
                laBeanTasks.add(transformBean(loTask));
            }
        }
        return laBeanTasks;
    }
}
