package com.example.domain.usecase;

import com.example.domain.Task;
import com.example.domain.rep.RepTask;

import java.util.List;

public class UCITask implements UCTask {

    private final RepTask ioRepTask;
    private CallBack ioCallBack;

    public UCITask(RepTask poRepTask) {
        if (poRepTask == null) {
            throw new IllegalArgumentException("No se inicializaron los parametros");
        }
        ioRepTask = poRepTask;
    }

    @Override
    public void getTasks(CallBack poCallBack) {
        ioCallBack = poCallBack;
        ioCallBack.onLoading("Cargando");
        ioRepTask.fnLSGetTasks(ioRepCallBack);
    }

    RepTask.CallBack ioRepCallBack = new RepTask.CallBack() {

        @Override
        public void onSuccess(List<Task> paTasks) {
            ioCallBack.onSuccess(paTasks);
        }

        @Override
        public void onError(String message) {
            ioCallBack.onError(message);
        }
    };
}
