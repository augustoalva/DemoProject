package com.example.listoftasks.di.comp;

import com.example.listoftasks.di.mod.ModActivity;
import com.example.listoftasks.view.act.ActTasks;

import dagger.Component;

@PerActivity
@Component(dependencies = CompApplication.class, modules = ModActivity.class)
public interface CompConActivity extends CompActivity {
    void inject(ActTasks poActTasks);
}
