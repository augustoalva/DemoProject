package com.example.listoftasks.view.act;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class ActBase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bindViews();
        setContext();
    }

    public void setContext(){
    }

    private void bindViews() {
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();
}
