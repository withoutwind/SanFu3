package MyAdapters;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.aishangsanfu.R;

import java.util.ArrayList;

import Datas.Datas2;
import MyView.NoScrollGridView;

/**
 * Created by Administrator on 2016/10/12.
 */

public class PtrListAdapter extends BaseAdapter {
    private ArrayList<Datas2.MsgBean.CategoryBean.List2Bean> datas;

    public PtrListAdapter(ArrayList<Datas2.MsgBean.CategoryBean.List2Bean> datas) {
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
        if(convertView==null){
            vh=new ViewHolder();
            convertView=View.inflate(parent.getContext(), R.layout.ptrlistview_item,null);
            vh.tv= (TextView) convertView.findViewById(R.id.ptr_textview);
            vh.tv2= (TextView) convertView.findViewById(R.id.ptr_textview2);
            vh.gv= (NoScrollGridView) convertView.findViewById(R.id.ptr_grview);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        vh.tv.setText(datas.get(position).getName());
        vh.tv2.setText("查看详情>");
        vh.gv.setSelector(new ColorDrawable(Color.TRANSPARENT));
        vh.gv.setAdapter(new SortgritAdapter((ArrayList<Datas2.MsgBean.CategoryBean.List2Bean.List3Bean>) datas.get(position).getList2()));
        return convertView;
    }
    class ViewHolder{
        TextView tv,tv2;
        NoScrollGridView gv;

    }
}
