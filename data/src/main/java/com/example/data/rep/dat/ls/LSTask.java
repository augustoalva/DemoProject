package com.example.data.rep.dat.ls;

import android.content.Context;

import com.example.data.ent.EntTask;
import com.example.data.rep.dal.DalGestor;
import com.example.data.rep.dat.DSTask;

import java.util.ArrayList;
import java.util.List;

public class LSTask extends DalGestor implements DSTask {

    public LSTask(Context poContext) {
        super(poContext);
    }

    @Override
    public void getTasks(CallBack poCallBack) {
        List<EntTask> laEntTasks = new ArrayList<>();
        EntTask ioEntTask = new EntTask();
        ioEntTask.setId("1")
                .setTask("Plan de trabajo");
        laEntTasks.add(ioEntTask);

        ioEntTask = new EntTask();
        ioEntTask.setId("2")
                .setTask("Análisis del proyecto");

        laEntTasks.add(ioEntTask);

        poCallBack.onSuccess(laEntTasks);
    }
}
