package com.example.domain;

import android.support.annotation.Nullable;

public class Response<T> {
    public String message;
    public T object;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Response(String message, @Nullable T object) {
        this.message = message;
        this.object = object;
    }
}
