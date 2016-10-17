package Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.administrator.aishangsanfu.R;

import org.greenrobot.eventbus.EventBus;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;

import Bean.SortBean;
import MyAdapters.SortMyAdapter;

import static Utils.Constans.sortdatas;

/**
 * Created by Administrator on 2016/10/12.
 */

public class CategoryFragment extends BaseFragment implements AdapterView.OnItemClickListener{
<<<<<<< HEAD
   private ArrayList<Datas2.MsgBean.CategoryBean> datas=new ArrayList<>();
=======
>>>>>>> github3/master
    private ArrayList<Fragment> fdatas=new ArrayList<>();
    private ListView listView;
    private SortMyAdapter adapter;
    private MyFragment myFragment;
    public static int mPosition;
    private View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(getActivity());

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.sortfragment,null);
        //initDatas();
        initView();
        return view;
    }
<<<<<<< HEAD

    private void initDatas(){

        RequestParams params =new RequestParams("http://m.sanfu.com/app/goods/sort.htm?source=1&version=1");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                JSONObject jj= JSON.parseObject(s);
                String root=jj.getString("msg");
                JSONObject jb= JSON.parseObject(root);
                String s1=jb.getString("category");
                JSONArray jsonArray = JSON.parseArray(s1);
                for (Object o : jsonArray) {
                    Datas2.MsgBean.CategoryBean n = JSON.parseObject(o.toString(), Datas2.MsgBean.CategoryBean.class);
                    datas.add(n);
                }
                //EventBus.getDefault().post(datas.get(0));
                for (int i = 0; i < datas.size(); i++) {
                    myFragment=new MyFragment();
                    fdatas.add(myFragment);
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
        });

    }




      //初始化view

=======
    /**
     * 初始化view
     */
>>>>>>> github3/master
    private void initView() {
        listView = (ListView)view.findViewById(R.id.listview);
        listView.setDivider(null);
        adapter = new SortMyAdapter(sortdatas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        //创建MyFragment对象
        myFragment = new MyFragment();
        EventBus.getDefault().post(sortdatas.get(0));
        toFragment(myFragment);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        //拿到当前位置
        mPosition = position;
        //即使刷新adapter
        adapter.notifyDataSetChanged();
        myFragment = new MyFragment();
        toFragment(myFragment);
        EventBus.getDefault().post(sortdatas.get(position));



    }
    public void toFragment(Fragment f){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).commit();

    }
}
