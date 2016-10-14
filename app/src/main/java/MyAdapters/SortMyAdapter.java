package MyAdapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.aishangsanfu.R;

import java.util.ArrayList;

import Datas.Datas2;
import Fragment.CategoryFragment;

/**
 * Created by Administrator on 2016/10/12.
 */

public class SortMyAdapter extends BaseAdapter {
    private ArrayList<Datas2.MsgBean.CategoryBean> datas;
    public static int mPosition;

    public SortMyAdapter(ArrayList<Datas2.MsgBean.CategoryBean> datas){
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, null);
        TextView tv = (TextView) convertView.findViewById(R.id.tv);
        mPosition = position;
        tv.setText(datas.get(position).getName().toString());
        if (position == CategoryFragment.mPosition) {
            convertView.setBackgroundColor(Color.parseColor("#ffffffff"));
            tv.setTextColor(Color.parseColor("#ff0033"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#f4f4f4"));
        }
        return convertView;
    }
}
