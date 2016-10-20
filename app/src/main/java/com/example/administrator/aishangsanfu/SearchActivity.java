package com.example.administrator.aishangsanfu;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Bean.SearchBean;
import MyAdapters.FreshGridAdapter;
import Utils.HttpUtil;
import Utils.UIUtils;

public class SearchActivity extends AppCompatActivity {

    private String searchJson,s;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            adapter.notifyDataSetChanged();
        }
    };
    private PullToRefreshGridView mPullToRefreshGridView;
    private FreshGridAdapter adapter;
    private SearchBean searchBean;
    private LinkedList<Map<String, Object>> data = new LinkedList<>();
    private List<SearchBean.MsgBean.GoodsInfosBean> list = new ArrayList<>();
    private int i= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initData();
        initView();

    }

    private void initData() {
        new Thread() {
            @Override
            public void run() {
                String goodsSearch = "http://m.sanfu.com/app/goods/goodsList.htm?goods.class_id=&page="+i+"&pageSize=40&goods.search_words=" +getIntent().getStringExtra("keyword")+ "&goods.is_disc=0&goods.is_hot=0&goods.is_new=2&goods.is_best=0&sid=a9f809a7c00111dd3abc3d49a06da2e4&source=1&key=lflrnhsahuogcuy&sign=E88688DE70D40C1B098A2BCABA4756C7";
                String json1 = HttpUtil.down(goodsSearch);
                SearchBean searchBean = JSON.parseObject(json1, SearchBean.class);
                List<SearchBean.MsgBean.GoodsInfosBean> list = searchBean.getMsg().getGoodsInfos();
                for (SearchBean.MsgBean.GoodsInfosBean bean: list){
                    Map<String,Object> map = new HashMap<>();
                    map.put("l_img",bean.getL_img());
                    map.put("goods_name",bean.getGoods_name());
                    map.put("mb_price",bean.getMb_price());
                    data.add(map);
                }
                handler.sendEmptyMessage(0);
            }
        }.start();


    }


    private  void  initView(){
        mPullToRefreshGridView = (PullToRefreshGridView) findViewById(R.id.goods_list_gridview);
        View view = findViewById(R.id.goods_list_linearlayout_no_data);
        mPullToRefreshGridView.setEmptyView(view);
        adapter = new FreshGridAdapter(this,data);
        mPullToRefreshGridView.setAdapter(adapter);
        mPullToRefreshGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                initData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                i++;
                initData();

            }
        });
    }
}
