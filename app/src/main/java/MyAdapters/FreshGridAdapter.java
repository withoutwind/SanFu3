package MyAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.aishangsanfu.R;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/17.
 */

public class FreshGridAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private LinkedList<Map<String, Object>> data;

    public FreshGridAdapter(Context context, LinkedList<Map<String, Object>> data) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.data = data;
        System.out.println("333333333"+data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.fresh_grid_item, null);
            vh.iv = (ImageView) convertView.findViewById(R.id.fresh_img);
            vh.name = (TextView) convertView.findViewById(R.id.fresh_name);
            vh.price = (TextView) convertView.findViewById(R.id.fresh_price);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        System.out.println("@@@"+data);
        vh.name.setText((String) data.get(position).get("goods_name"));
        vh.price.setText("¥" + (Integer) data.get(position).get("mb_price") + ".00");
        String url = (String) data.get(position).get("l_img");
        System.out.println("----11"+data);
        if (!"".equals(url)) {
            Picasso.with(context).load(url).into(vh.iv);
        } else {
            Picasso.with(context).load(R.drawable.error).into(vh.iv);
        }
        return convertView;
    }


    class ViewHolder {
        ImageView iv;
        TextView name;
        TextView price;

    }
}


