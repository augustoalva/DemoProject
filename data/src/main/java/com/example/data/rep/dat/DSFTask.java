package com.example.data.rep.dat;

import android.content.Context;

import com.example.data.rep.dat.ls.LSTask;

public class DSFTask {
    private Context ioContext;

    public DSFTask(Context poContext) {
        if (poContext == null) {
            throw new IllegalArgumentException("No se puede inicializar el constructor");
        }
        ioContext = poContext;
    }

    public DSTask subCreateFromLocalStorage() {
        return new LSTask(ioContext);
    }
}
