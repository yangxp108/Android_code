package com.example.yangxiaoping.mapmap;


import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yangxiaoping.mapmap.EventBus.FirstEvent;
import com.example.yangxiaoping.mapmap.EventBus.SecondEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by yangxiaoping on 2016/9/6.
 */
public class XiaoshuFregment extends Fragment implements View.OnClickListener{
    private Context context;
    private View view;
    private Button oncklice;
    private HomeFregment homefregment;
    private TextView textv;
    private Button btn_FirstEvent,btn_SecondEvent;

    private onClickeLesnerl onTestclicke;

    public void setOnClickeLesnerl(onClickeLesnerl onTestclicke) {
        this.onTestclicke = onTestclicke;

    }

    public interface onClickeLesnerl {
        void clice(String str);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_xiaoshufregment,null);
        oncklice = (Button) view.findViewById(R.id.oncklice);
        oncklice.setOnClickListener(this);
        textv=(TextView)view.findViewById(R.id.oncklice);

        btn_FirstEvent = (Button)view.findViewById(R.id.btn_first_event);
        btn_FirstEvent.setOnClickListener(this);
        btn_SecondEvent = (Button)view.findViewById(R.id.btn_second_event);
        btn_SecondEvent.setOnClickListener(this);

        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setOnClickeLesnerl((onClickeLesnerl)getActivity());


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.oncklice:
                onTestclicke.clice("2016是我一生中最幸福也就是遇见你！哈哈");

                break;
            case R.id.btn_first_event:
                EventBus.getDefault().post(new FirstEvent("嘿嘿，被你发现了"));

                break;
            case R.id.btn_second_event:
                EventBus.getDefault().post(new SecondEvent("哈哈,你又知道了"));

                break;
        }
    }
}
