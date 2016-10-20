package MyAdapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.aishangsanfu.R;

import Bean.DetailsBean;

/**
 * Created by Administrator on 2016/10/19.
 */

public class DescriptionAdapter extends BaseAdapter {
    private String[] sdatas,datas;

    private Context context;

    public DescriptionAdapter(Context context,String[]sdatas, String[] datas) {
        this.sdatas = sdatas;
        this.datas = datas;
        this.context=context;
    }

    @Override
    public int getCount() {
        return sdatas.length;
    }

    @Override
    public Object getItem(int position) {
        return sdatas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if(convertView==null){
            vh=new ViewHolder();
            convertView=View.inflate(context, R.layout.descriptionlist,null);
            vh.tv1= (TextView) convertView.findViewById(R.id.list_tv1);
            vh.tv2= (TextView) convertView.findViewById(R.id.list_tv2);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        vh.tv1.setText(sdatas[position]);
        vh.tv2.setText(datas[position]);
        return convertView;
    }

    class ViewHolder {
        TextView tv1, tv2;
    }
}
