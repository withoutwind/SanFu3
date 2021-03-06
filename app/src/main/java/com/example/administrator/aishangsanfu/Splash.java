package com.example.administrator.aishangsanfu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

import Bean.HomeBean;
import Bean.SortBean;
import Utils.HttpUtil;
import Utils.UIUtils;

import static Utils.Constans.homeStr;
import static Utils.Constans.indexBeanList;
import static Utils.Constans.sortdatas;
import static Utils.Constans.sorturl;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        init();
        inData();

    }


    private void inData() {
        new Thread( ){
            @Override
            public void run() {
                String json = HttpUtil.loadJSON(homeStr);
                HomeBean hb = JSON.parseObject(json,HomeBean.class);
                indexBeanList = hb.getMsg().getIndex();
                String s = HttpUtil.loadJSON(sorturl);
                SortBean sb=JSON.parseObject(s,SortBean.class);
                SortBean.MsgBean sm=sb.getMsg();
                sortdatas = (ArrayList<SortBean.MsgBean.CategoryBean>) sm.getCategory();

            }
        }.start();
    }

    private void init() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    UIUtils.getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            Intent it = new Intent(UIUtils.getContext(), MainActivity.class);
                            startActivity(it);
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
