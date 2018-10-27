package com.example.listoftasks.di.mod;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModApplication {
    private final Application application;

    public ModApplication(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application application() {

        return application;
    }
}
