package com.zeasn.zero0.bean;

public class Event<T> {
    private int code;
    private T data;

    public Event(int code) {
        this.code = code;
    }

    public Event(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getEventCode() {
        return code;
    }

    public T getEventData() {
        return data;
    }

}
