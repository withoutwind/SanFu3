package Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.aishangsanfu.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import Bean.SortBean;
import MyAdapters.PtrListAdapter;

/**
 * Created by Administrator on 2016/10/12.
 */

public class MyFragment extends Fragment {
    private SortBean.MsgBean.CategoryBean data;
    private PullToRefreshListView ptrListView;
    private PtrListAdapter adapter;
    public static int width,height;

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
        ptrListView= (PullToRefreshListView) view.findViewById(R.id.pulltolist);
        ImageView iv=new ImageView(getActivity());
        try {
            Picasso.with(getContext()).load(data.getImg()).resize(width,height).centerCrop().into(iv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ListView listView=ptrListView.getRefreshableView();
        listView.addHeaderView(iv);
        adapter=new PtrListAdapter((ArrayList<SortBean.MsgBean.CategoryBean.List2Bean>) data.getList2());
        ptrListView.setAdapter(adapter);
        onClick();
        return view;
    }

    private void onClick() {
        ptrListView.setMode(PullToRefreshBase.Mode.BOTH);
        //上拉下拉刷新数据
        ptrListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                System.out.println("--ssss111");
                adapter.notifyDataSetChanged();
                System.out.println("--ssss");
                ptrListView.onRefreshComplete();
                System.out.println("--ssss222");
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                adapter.notifyDataSetChanged();
                System.out.println("--ssss");
                ptrListView.onRefreshComplete();
                System.out.println("--ssss222");
            }
        });
        //点击跳转

    }
}
