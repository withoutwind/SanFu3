package com.example.administrator.aishangsanfu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Utils.UIUtils;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        init();
    }

    private void init() {

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
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
