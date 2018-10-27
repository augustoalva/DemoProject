package com.example.data.rep.dat;

import com.example.data.ent.EntTask;
import com.example.domain.EError;

import java.util.List;

public interface DSTask {

    interface CallBack {

        void onSuccess(List<EntTask> paEntTasks);

        void onError(EError poEError);

    }

    void getTasks(CallBack poCallBack);
}
