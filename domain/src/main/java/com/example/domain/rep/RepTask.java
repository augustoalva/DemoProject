package com.example.domain.rep;

import com.example.domain.Task;

import java.util.List;

public interface RepTask {

    interface CallBack {
        void onSuccess(List<Task> paTasks);
        void onError(String message);
    }

    void fnCSGetTasks(CallBack poCallBack);

    void fnLSGetTasks(CallBack poCallBack);
}
