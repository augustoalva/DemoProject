package com.example.domain;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ResponseList<T> {
    public String message;
    public List<T> list = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public ResponseList(@Nullable String message, @Nullable List<T> list) {
        this.message = message;
        this.list = list;
    }
}
