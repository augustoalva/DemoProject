package com.example.listoftasks.pre;

import android.content.Context;

import com.example.domain.Task;
import com.example.domain.usecase.UCTask;
import com.example.listoftasks.model.map.MapTask;
import com.example.listoftasks.view.ViewActTasks;

import java.util.List;

import javax.inject.Inject;

public class PreActComputers {

    private final static String TAG = PreActComputers.class.getSimpleName();

    private final ViewActTasks ioViewActTasks;
    private final UCTask ioUCTask;
    private final MapTask ioMapTask;
    private final Context ioContext;

    @Inject
    public PreActComputers(ViewActTasks poViewActTasks, UCTask poUCTask, MapTask poMapTask) {

        if (poViewActTasks == null) {
            throw new IllegalArgumentException("Variables no inicializadas");
        }

        this.ioViewActTasks = poViewActTasks;
        this.ioUCTask = poUCTask;
        this.ioMapTask = poMapTask;
        this.ioContext = ioViewActTasks.getContext();
    }

    public void getTasks() {
        ioUCTask.getTasks(ioCallBack);
    }

    UCTask.CallBack ioCallBack = new UCTask.CallBack() {
        @Override
        public void onLoading(String poMessage) {
            ioViewActTasks.onLoading(poMessage);
        }

        @Override
        public void onSuccess(List<Task> paTasks) {
            ioViewActTasks.onSuccess(null, ioMapTask.transformBean(paTasks));
        }

        @Override
        public void onError(String poMessage) {
            ioViewActTasks.onError(poMessage);
        }
    };

}
