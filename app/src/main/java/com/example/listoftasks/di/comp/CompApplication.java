package com.example.listoftasks.di.comp;

import android.app.Application;

import com.example.listoftasks.AppDemo;
import com.example.listoftasks.di.mod.ModApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ModApplication.class)
public interface CompApplication {

    void inject(AppDemo application);

    Application application();
}
