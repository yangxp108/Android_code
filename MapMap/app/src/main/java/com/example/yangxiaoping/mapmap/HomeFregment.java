package com.example.yangxiaoping.mapmap;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yangxiaoping.mapmap.EventBus.FirstEvent;
import com.example.yangxiaoping.mapmap.EventBus.SecondEvent;

import org.w3c.dom.Text;

import de.greenrobot.event.EventBus;

/**
 * Created by yangxiaoping on 2016/9/6.
 */
public class HomeFregment extends Fragment{

    private View view;
    private TextView oncklice, textstr;
    private String strs = "";

    private EventBus eventBus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_homefregment, null);
        oncklice = (TextView) view.findViewById(R.id.oncklice);
        textstr = (TextView) view.findViewById(R.id.textstr);

        Bundle bundle = getArguments();
        if (bundle != null) {
            textstr.setText(bundle.getString("key"));
            Log.i("string", "string=" + bundle.getString("key"));
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    public void onEventMainThread(FirstEvent event) {
        Log.d("harvic", "onEventMainThread收到了消息：" + event.getMsg());

    }


    public void onEventMainThread(SecondEvent event) {
        Log.d("harvic", "onEventMainThread收到了消息：" + event.getMsg());
    }


}
