package com.example.week.net;

public interface NetWork {
    public <T> void getLogin(String url,CallBackinterface<T> callBack);
}
