package com.example.administrator.aishangsanfu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import Fragment.BaseFragment;
import Fragment.FrgmentFactory;
import Fragment.HomeFragment;


public class MainActivity extends AppCompatActivity{
    private Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new HomeFragment()).commit();
        //initSlidingMenu();
        initFragment();
    }
    public  void initFragment(){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                BaseFragment f = null;
                int j=0;
                switch (i) {
                    case R.id.home:
                        j=0;
                        f = FrgmentFactory.createFragment(j);
                        break;
                    case R.id.category:
                        j=1;
                        System.out.println("--"+i);
                        f = FrgmentFactory.createFragment(j);
                        break;
                    case R.id.shop:
                        j=2;
                        System.out.println("--"+i);
                        f = FrgmentFactory.createFragment(j);

                        break;
                    case R.id.user:
                        j=3;
                        System.out.println("--"+i);
                        f = Fragment.FrgmentFactory.createFragment(j);

                        break;

                }
                change(f);
            }
        });


    }
    public void  change(BaseFragment f ){
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,f).commit();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Intent it=new Intent(this,QRcodeActivity.class);
            it.putExtra("valus",result);
            startActivity(it);
        }
    }







    }
