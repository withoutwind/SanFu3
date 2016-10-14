package MyAdapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.aishangsanfu.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Datas.Datas2;
import Fragment.MyFragment;

/**
 * Created by Administrator on 2016/10/12.
 */

public class SortgritAdapter extends BaseAdapter {
    private ArrayList<Datas2.MsgBean.CategoryBean.List2Bean.List3Bean> datas;

    public SortgritAdapter(ArrayList<Datas2.MsgBean.CategoryBean.List2Bean.List3Bean> datas) {
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
            convertView=View.inflate(parent.getContext(), R.layout.ptr_gridview,null);
            vh.iv= (ImageView) convertView.findViewById(R.id.grit_image);
            vh.tv= (TextView) convertView.findViewById(R.id.grit_text);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        try {
            Picasso.with(parent.getContext()).load(datas.get(position).getImg()).resize(MyFragment.width*6/23,MyFragment.width*12/23).centerCrop().into(vh.iv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        vh.tv.setText(datas.get(position).getName().toString());
        return convertView;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
