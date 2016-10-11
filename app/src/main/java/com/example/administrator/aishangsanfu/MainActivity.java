package com.example.administrator.aishangsanfu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.aishangsanfu.Datas.Get;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String mm=Get.getDatas("http://m.sanfu.com/app/goods/index.htm?id=101&version=3&source=1");
        System.out.println("--data1"+mm);
    }
}
