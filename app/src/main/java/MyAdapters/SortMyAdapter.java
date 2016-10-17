package MyAdapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.aishangsanfu.R;

import java.util.ArrayList;

import Bean.SortBean;
import Fragment.CategoryFragment;

/**
 * Created by Administrator on 2016/10/12.
 */

public class SortMyAdapter extends BaseAdapter {
    private ArrayList<SortBean.MsgBean.CategoryBean> datas;
    public static int mPosition;

    public SortMyAdapter(ArrayList<SortBean.MsgBean.CategoryBean> datas){
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
        ViewHolder vh=null;
        if (convertView==null){
            vh=new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, null);
            vh.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        mPosition = position;
        vh.tv.setText(datas.get(position).getName().toString());
        if (position == CategoryFragment.mPosition) {
            convertView.setBackgroundColor(Color.parseColor("#ffffffff"));
            vh.tv.setTextColor(Color.parseColor("#ff0033"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#f4f4f4"));
            vh.tv.setTextColor(Color.parseColor("#000000"));
        }
        return convertView;
    }
    class ViewHolder{
        TextView tv;
    }
}
