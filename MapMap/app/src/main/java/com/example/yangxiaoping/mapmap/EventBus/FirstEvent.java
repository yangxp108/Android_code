package com.example.yangxiaoping.mapmap.EventBus;

/**
 * Created by yangxiaoping on 2016/9/23.
 */
public class FirstEvent {
    private String mMsg;

    public FirstEvent(String msg){
        this.mMsg=msg;
    }

    public String getMsg(){
        return mMsg;
    }

}
