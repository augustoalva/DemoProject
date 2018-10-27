package com.example.listoftasks.di.mod;

import com.example.listoftasks.view.ViewActTasks;
import com.example.listoftasks.view.ViewLoadData;
import com.example.listoftasks.view.act.ActBase;

import dagger.Module;
import dagger.Provides;

@Module
public class ModActivity extends ModProvides {

    private final ActBase ioActBase;

    public ModActivity(ActBase poActBase, ViewLoadData poViewLoadData) {
        super(poViewLoadData);
        this.ioActBase = poActBase;
    }

    /*
    ************************************************************************************************
    * VIEW
    ************************************************************************************************
    * */

    @Provides
    ViewActTasks provideViewActTasks() {
        if (ioViewLoadData instanceof ViewActTasks)
            return (ViewActTasks) ioViewLoadData;
        else
            return null;
    }

    /*
    ************************************************************************************************
    * ACTIVITY
    ************************************************************************************************
    * */
    @Provides
    public ActBase activity() {
        return ioActBase;
    }
}
