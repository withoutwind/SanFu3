package com.example.administrator.aishangsanfu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import Utils.HttpUtil;

public class ListGoodsActivity extends AppCompatActivity {
    private  String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_goods);
        String item = getIntent().getStringExtra("item");
        String url = getIntent().getStringExtra("url");
        System.out.println("@@@"+item);
        System.out.println("@@@"+url);
        initData();
    }

    private void initData() {
        new Thread( ){
            @Override
            public void run() {
                String jsonlist = HttpUtil.loadJSON(url);
                 System.out.println("---sss"+jsonlist);


            }
        }.start();
    }
    }



