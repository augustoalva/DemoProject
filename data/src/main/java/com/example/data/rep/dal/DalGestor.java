package com.example.data.rep.dal;

import android.content.Context;

public class DalGestor {
    Context context;

    public DalGestor(Context poContext) {
        this.context = poContext;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
