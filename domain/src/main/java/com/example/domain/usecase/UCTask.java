package com.example.domain.usecase;

import com.example.domain.Task;

import java.util.List;

public interface UCTask {

    interface CallBack {
        void onLoading(String poMessage);

        void onSuccess(List<Task> paTasks);

        void onError(String poMessage);

    }

    void getTasks(CallBack poCallBack);
}
