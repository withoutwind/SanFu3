package com.example.administrator.aishangsanfu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class QRcodeActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        String arcurl=getIntent().getStringExtra("valus");
        System.out.println("--arc"+arcurl);
        wv= (WebView) findViewById(R.id.webView);
        wv.setWebViewClient(new WebViewClient());
        WebSettings ws=wv.getSettings();
        ws.setJavaScriptEnabled(true);
        wv.loadUrl(arcurl);
    }
    public void back(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}
