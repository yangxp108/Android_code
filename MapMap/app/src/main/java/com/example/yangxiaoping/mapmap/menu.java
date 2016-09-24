package com.example.yangxiaoping.mapmap;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

/**
 * Created by yangxiaoping on 2016/9/6.
 */
public class menu extends FragmentActivity implements View.OnClickListener, XiaoshuFregment.onClickeLesnerl {
    private FragmentManager fm=null;
    private FragmentTransaction transaction=null;
    private HomeFregment homeFregment;
    private XiaoshuFregment xiaoshuFregment;


    private TextView heome, xiaoshuframe;
    private FrameLayout xishu, homeframe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

        setDefaultFregment();
        init();
    }

    private void init() {
        heome = (TextView) findViewById(R.id.heome);
        heome.setOnClickListener(this);
        xiaoshuframe = (TextView) findViewById(R.id.xiaoshuframe);
        xiaoshuframe.setOnClickListener(this);
        xishu = (FrameLayout) findViewById(R.id.xishu);
        homeframe = (FrameLayout) findViewById(R.id.homeframe);

    }

    private void setDefaultFregment() {
         fm= getFragmentManager();
        //开启事务
        transaction = fm.beginTransaction();
        homeFregment = new HomeFregment();
        transaction.replace(R.id.homeframe, homeFregment);
        transaction.commit();

    }


    @Override
    public void onClick(View view) {
         fm = getFragmentManager();
         transaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.heome:
                homeframe.setVisibility(View.VISIBLE);
                xishu.setVisibility(View.GONE);
                if (homeFregment == null) {
                    homeFregment = new HomeFregment();
                    transaction.replace(R.id.homeframe, homeFregment);
                    transaction.commit();

                }

                Log.i("onclick", "onclick");
                break;
            case R.id.xiaoshuframe:
                Log.i("onclick", "onclick");
                xishu.setVisibility(View.VISIBLE);
                homeframe.setVisibility(View.GONE);
                if (xiaoshuFregment == null) {
                    xiaoshuFregment = new XiaoshuFregment();
                    transaction.replace(R.id.xishu, xiaoshuFregment);
                    transaction.commit();

                }


                break;
        }

    }

    @Override
    public void clice(String str) {
         fm = getFragmentManager();
        //开启事务
        transaction = fm.beginTransaction();
        homeFregment = new HomeFregment();
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        homeFregment.setArguments(bundle);
        transaction.replace(R.id.homeframe, homeFregment);
        transaction.commitAllowingStateLoss();
        xishu.setVisibility(View.GONE);
        homeframe.setVisibility(View.VISIBLE);


    }
}
