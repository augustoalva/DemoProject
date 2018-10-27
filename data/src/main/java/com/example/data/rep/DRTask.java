package com.example.data.rep;

import com.example.data.ent.EntTask;
import com.example.data.ent.map.DMTask;
import com.example.data.rep.dat.DSFTask;
import com.example.data.rep.dat.DSTask;
import com.example.domain.EError;
import com.example.domain.rep.RepTask;

import java.util.List;


public class DRTask implements RepTask {

    public static DRTask INSTANCE;
    private final DSFTask ioDSFTask;
    private final DMTask ioDMTask;
    private CallBack ioCallBack;

    public DRTask(DSFTask poDSFTask, DMTask poDMTask) {
        if (poDSFTask == null || poDMTask == null) {
            throw new IllegalArgumentException("Invalid null parameters in constructor!!!");
        }
        this.ioDSFTask = poDSFTask;
        this.ioDMTask = poDMTask;
    }

    public static synchronized DRTask getInstance(DSFTask poDSFDSFComputer, DMTask poDMTask) {
        if (INSTANCE == null) {
            INSTANCE = new DRTask(poDSFDSFComputer, poDMTask);
        }
        return INSTANCE;
    }

    @Override
    public void fnCSGetTasks(CallBack poCallBack) {

    }

    @Override
    public void fnLSGetTasks(CallBack poCallBack) {
        ioCallBack = poCallBack;
        ioDSFTask.subCreateFromLocalStorage().getTasks(ioDSCallBack);
    }

    DSTask.CallBack ioDSCallBack = new DSTask.CallBack() {

        @Override
        public void onSuccess(List<EntTask> paEntTasks) {
            ioCallBack.onSuccess(ioDMTask.transform(paEntTasks));
        }

        @Override
        public void onError(EError poEError) {
            ioCallBack.onError(poEError.getMessage());
        }
    };
}
