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
        if (sortdatas!=null){
            initView();
        }
        return view;
    }
    /**
     * 初始化view
     */
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
