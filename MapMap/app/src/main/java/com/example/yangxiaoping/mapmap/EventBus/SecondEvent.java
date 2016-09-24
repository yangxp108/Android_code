package com.example.yangxiaoping.mapmap.EventBus;

/**
 * Created by yangxiaoping on 2016/9/23.
 */
public class SecondEvent {

    private String mMsg;

    public SecondEvent(String msg) {
        mMsg = "MainEvent:"+msg;
    }
    public String getMsg(){
        return mMsg;
    }
}
