package com.example.listoftasks.view;

import com.example.listoftasks.model.BeanTask;

import java.util.List;

public interface ViewActTasks extends ViewLoadData {

    void onSuccess(String message, List<BeanTask> paBeanTask);

}
