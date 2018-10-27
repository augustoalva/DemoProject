package com.example.listoftasks;

import android.app.Application;

import com.example.listoftasks.di.comp.CompApplication;
import com.example.listoftasks.di.comp.DaggerCompApplication;
import com.example.listoftasks.di.mod.ModApplication;

public class AppDemo extends Application {

    private CompApplication ioCompApplication;

    public CompApplication component() {
        return ioCompApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

       ioCompApplication = DaggerCompApplication.builder()
                .modApplication(new ModApplication(this))
                .build();
    }
}
