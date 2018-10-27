package com.example.listoftasks.di.comp;

import com.example.listoftasks.di.mod.ModActivity;
import com.example.listoftasks.view.act.ActBase;

import dagger.Component;

@PerActivity
@Component(dependencies = CompApplication.class, modules = ModActivity.class)
public interface CompActivity {

    ActBase activity();
}
