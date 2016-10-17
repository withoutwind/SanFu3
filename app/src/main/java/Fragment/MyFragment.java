package Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.aishangsanfu.Main2Activity;
import com.example.administrator.aishangsanfu.R;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import Bean.SortBean;
import MyAdapters.PtrListAdapter;
import Utils.Currenttime;

/**
 * Created by Administrator on 2016/10/12.
 */

public class MyFragment extends Fragment {
    private String currentTime;
    private SortBean.MsgBean.CategoryBean data;
    private PullToRefreshListView ptrListView;
    private PtrListAdapter adapter;
    public static int width,height;
    Handler handler=new Handler();


    public MyFragment() {
        EventBus.getDefault().register(this);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        width=getActivity().getWindowManager().getDefaultDisplay().getWidth()*18/23;
        height=width*2/5;
        System.out.println("--width"+width);


    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void change(SortBean.MsgBean.CategoryBean data){
        this.data=data;
        //adapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.myfragment,null);
        TextView tv=new TextView(getActivity());

        ptrListView= (PullToRefreshListView) view.findViewById(R.id.pulltolist);
        ImageView iv=new ImageView(getActivity());
        try {
            tv.setText("已经到底了");
            Picasso.with(getContext()).load(data.getImg()).resize(width,height).centerCrop().into(iv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ListView listView=ptrListView.getRefreshableView();
        listView.addHeaderView(iv);
        listView.addFooterView(tv);
        adapter=new PtrListAdapter((ArrayList<SortBean.MsgBean.CategoryBean.List2Bean>) data.getList2());
        ptrListView.setAdapter(adapter);
        currentTime= Currenttime.getCurrenttime();
        onRefresh();
        onClick();
        return view;
    }

    private void onRefresh() {
        ptrListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        //上拉下拉刷新数据
        ptrListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                ILoadingLayout startLabels = refreshView
                        .getLoadingLayoutProxy(true, false);
                startLabels.setPullLabel("下拉可以刷新");// 刚下拉时，显示的提示
                startLabels.setRefreshingLabel("正在载入中");// 刷新时
                startLabels.setReleaseLabel("松开后刷新");// 下来达到一定距离时，显示的提示
                startLabels.setLastUpdatedLabel("最后更新时间:"+currentTime);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        currentTime=Currenttime.getCurrenttime();
                        ptrListView.onRefreshComplete();
                    }
                });
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        ptrListView.onRefreshComplete();
                    }
                });
            }
        });
    }

    private void onClick() {
        ptrListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(getActivity(), Main2Activity.class);
                startActivity(it);
            }
        });

    }
}
