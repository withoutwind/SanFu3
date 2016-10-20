package com.example.administrator.aishangsanfu;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;

import Bean.DetailsBean;
import Fragment.MyFragment;
import MyAdapters.DescriptionAdapter;
import MyAdapters.DetailsPagerAdapter;
import MyView.NoScrollGridView;
import Utils.Constans;

public class ProductDetailsActivity extends AppCompatActivity {
    private ArrayList<View> datas = new ArrayList<>();
    private ArrayList<ImageView> list = new ArrayList<>();
    private DetailsBean.MsgBean msgBean;
    private String goods_us = "363036";
    private DetailsPagerAdapter adapter;
    private ViewPager vp;
    private LinearLayout ll, offorsll, offerchildll, evaluationsll, evaluationll, advisoryll, selectll;
    private int current = 0;
    private TextView evaluationtv, advisorytv, evaluationtv1, evaluationtv2, evaluationtv3,shooping_tv1,shooping_tv2,shooping_tv3;
    private WebView webView;
    private PopupWindow popupWindow;
    private String[] sdatas={"类型","季节","货号","系列","材质","风格","温馨提示","商品描述"};
    private String[] sdatas2;
    private ListView productparameters_listView;
    private View shoopingview ;
    private ImageView shoopingImage;
    private NoScrollGridView shooping_grid1,shooping_grid2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setContentView(R.layout.activity_product_details);
        ll = (LinearLayout) findViewById(R.id.goods_detail_new_lly_dot);
        offorsll = (LinearLayout) findViewById(R.id.goods_detial_new_see_offers);
        evaluationsll = (LinearLayout) findViewById(R.id.goods_detail_new_vpg_pin_and_wen);
        evaluationll = (LinearLayout) View.inflate(this, R.layout.evaluation, null);
        advisoryll = (LinearLayout) View.inflate(this, R.layout.advisory, null);
        evaluationtv = (TextView) findViewById(R.id.goods_detial_new_txv_pinjia);
        evaluationtv1 = (TextView) evaluationll.findViewById(R.id.evaluation_tv2);
        evaluationtv2 = (TextView) evaluationll.findViewById(R.id.evaluation_tv3);
        evaluationtv3 = (TextView) evaluationll.findViewById(R.id.evaluation_tv1);
        advisorytv = (TextView) findViewById(R.id.goods_detial_new_txv_wenda);
        selectll = (LinearLayout) findViewById(R.id.goods_detail_new_liy_selected_size_and_color);
        webView = (WebView) findViewById(R.id.goods_detial_new_webview);
        initDatas();

    }

    private void initDatas() {

        RequestParams params = new RequestParams(Constans.getDetailsUrl(goods_us));
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("--s" + s);
                DetailsBean db = JSON.parseObject(s, DetailsBean.class);
                msgBean = db.getMsg();
                for (int i = 0; i < msgBean.getGoodsPhotolist().size(); i++) {
                    if (i == 0) {
                        ImageView imagv = new ImageView(getBaseContext());
                        imagv.setImageResource(R.drawable.i_guide_round_selected);
                        ll.addView(imagv);
                    } else {
                        ImageView imagv = new ImageView(getBaseContext());
                        imagv.setImageResource(R.drawable.i_guide_round);
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT);
                        lp.setMargins(15, 0, 0, 0);
                        imagv.setLayoutParams(lp);
                        ll.addView(imagv);
                    }
                    ImageView iv = new ImageView(getBaseContext());
                    Picasso.with(getBaseContext()).load(msgBean.getGoodsPhotolist().get(i).getM_img()).resize(MyFragment.screenWidth, MyFragment.screenWidth).centerCrop().into(iv);
                    datas.add(iv);
                }
                sdatas2= new String[]{msgBean.getGoodsProps().getPattern(), msgBean.getGoodsProps().getSeason(), String.valueOf(msgBean.getGoodsProps().getGoods_sn()), msgBean.getGoodsProps().getNetcollection(), msgBean.getGoodsProps().getMaterial(), msgBean.getGoodsProps().getGoostyle(), msgBean.getGoodsProps().getTips(), msgBean.getGoodsProps().getRemark()};
                for (int i = 0; i <msgBean.getGoodsSpeci().size() ; i++) {
                    stocknum+=msgBean.getGoodsSpeci().get(i).getNumber();
                }
                initView();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String s) {
                return false;
            }
        });

    }


    private void initView() {
        vp = (ViewPager) findViewById(R.id.goods_detail_new_vpg_image_scroll);
        adapter = new DetailsPagerAdapter(datas);
        vp.setAdapter(adapter);
        //设置监听
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == current) {
                    ((ImageView) ll.getChildAt(position)).setImageResource(R.drawable.i_guide_round_selected);
                } else {
                    ((ImageView) ll.getChildAt(position)).setImageResource(R.drawable.i_guide_round_selected);
                    ((ImageView) ll.getChildAt(current)).setImageResource(R.drawable.i_guide_round);
                    current = position;
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        TextView tv = (TextView) findViewById(R.id.goods_detail_new_txv_goods_name);
        tv.setText(msgBean.getGoods().getGoods_name() + msgBean.getGoods().getGoods_sn());
        TextView tv1 = (TextView) findViewById(R.id.goods_detail_new_txv_sale_num);
        tv1.setText("销售" + msgBean.getGoods().getNumber() + "件");
        TextView tv2 = (TextView) findViewById(R.id.goods_detial_new_buy_price);
        tv2.setText("¥" + (double) (msgBean.getGoods().getMb_price()));
        TextView tv3 = (TextView) findViewById(R.id.goods_detial_new_see_price);
        tv3.setText("VIP价:¥" + (double) (msgBean.getGoods().getMb_price()) * 90 / 100);
        for (int i = 0; i < msgBean.getPromolist().size(); i++) {
            offerchildll = (LinearLayout) View.inflate(this, R.layout.offers, null);
            TextView offertv = (TextView) offerchildll.findViewById(R.id.offers_textview1);
            TextView offertv2 = (TextView) offerchildll.findViewById(R.id.offers_textview2);
            offertv.setText(msgBean.getPromolist().get(i).getWayStr());
            offertv2.setText("【" + msgBean.getPromolist().get(i).getName() + "】");
            offorsll.addView(offerchildll);
        }
        try {
            if (msgBean.getCommentlist() != null) {
                if (msgBean.getCommentlist().get(0).getUser_realname() != null) {
                    evaluationtv1.setText(msgBean.getCommentlist().get(0).getUser_realname());
                }
                evaluationtv2.setText(msgBean.getCommentlist().get(0).getContentsStr());
                evaluationtv3.setText(msgBean.getCommentlist().get(0).getAddtimeStr() + "  颜色分类：" + msgBean.getCommentlist().get(0).getColor() + ";  尺码:" + msgBean.getCommentlist().get(0).getSize());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //默认商品评价
        evaluationsll.addView(evaluationll);
        /*webView.setWebViewClient(new WebViewClient());
        WebSettings ws=webView.getSettings();
        ws.setJavaScriptEnabled(true);*/
        webView.loadUrl(Constans.getWebview(msgBean.getGoods().getId()));




    }

    //点击商品评价或购买咨询
    public void change(View view) {
        switch (view.getId()) {
            case R.id.goods_detial_new_txv_pinjia:
                evaluationsll.removeAllViews();
                evaluationsll.addView(evaluationll);
                evaluationtv.setTextColor(Color.parseColor("#000000"));
                advisorytv.setTextColor(Color.parseColor("#FF848484"));
                break;
            case R.id.goods_detial_new_txv_wenda:
                evaluationsll.removeAllViews();
                evaluationsll.addView(advisoryll);
                advisorytv.setTextColor(Color.parseColor("#000000"));
                evaluationtv.setTextColor(Color.parseColor("#FF848484"));
                break;

        }
    }

    //点击选择商品颜色，尺码或产品参数或加入购物车
    public void popuup(View view) {
        switch (view.getId()) {
            case R.id.goods_detail_new_liy_selected_size_and_color:
                showDetailsMoreWindow(view, 1);
                break;
            case R.id.goods_detail_new_liy_shopping_items:
                showDetailsMoreWindow(view, 2);
                break;
            case R.id.goods_detail_new_txv_add_cart:
                showDetailsMoreWindow(view, 1);
                break;
        }
    }
    //弹出PopupWindow
    //库存，购买量
    int stocknum=0;
    int baynum=0;
    private void showDetailsMoreWindow(View asDropDown, int i) {


        if (i == 1) {
            //加入购物车页面
            shoopingview = LayoutInflater.from(this).inflate(
                    R.layout.shooping, null);
            shoopingImage= (ImageView) shoopingview.findViewById(R.id.select_goods_info_imv);
            shooping_tv1= (TextView) shoopingview.findViewById(R.id.select_goods_info_txv_price);
            shooping_tv2= (TextView) shoopingview.findViewById(R.id.select_goods_info_txv_num);
            Picasso.with(this).load(msgBean.getGoods().getL_img()).centerCrop().resize(100,70).into(shoopingImage);
            shooping_tv1.setText("¥" + (double) (msgBean.getGoods().getSc_price()));
            shooping_tv2.setText("库存("+stocknum+")件");
            shooping_grid1= (NoScrollGridView) shoopingview.findViewById(R.id.shooping_gridview1);
            shooping_grid2= (NoScrollGridView) shoopingview.findViewById(R.id.shooping_gridview2);

        } else {
            //产品参数
            shoopingview = LayoutInflater.from(this).inflate(
                    R.layout.productparameters, null);
            productparameters_listView= (ListView) shoopingview.findViewById(R.id.product_listview);
            productparameters_listView.setAdapter(new DescriptionAdapter(this,sdatas,sdatas2));
        }
        popupWindow = new PopupWindow(shoopingview, WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT, false);
        popupWindow = new PopupWindow(shoopingview);

        // 使其聚集
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // 设置SelectPicPopupWindow弹出窗体的宽
        int width = this.getWindowManager().getDefaultDisplay().getWidth();
        popupWindow.setWidth(width);
        // 设置SelectPicPopupWindow弹出窗体的高
        popupWindow.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 2 / 3);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        popupWindow.setAnimationStyle(R.style.AnimBottom);
        //popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.back_search_img));
        popupWindow.showAtLocation(asDropDown, Gravity.BOTTOM, 0, 0);
    }
    //Tobar点击事件
    public void click(View view){
        switch (view.getId()){
            case R.id.back:
                break;
            case R.id.tohome:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.share:
                break;
        }
    }
}
