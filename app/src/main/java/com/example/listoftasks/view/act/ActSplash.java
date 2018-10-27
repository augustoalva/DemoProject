package com.example.listoftasks.view.act;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.example.listoftasks.R;

import static com.example.listoftasks.ConfDemo.SPLASH_DISPLAY_LENGTH;

public class ActSplash extends ActBase {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(ActSplash.this, ActTasks.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
