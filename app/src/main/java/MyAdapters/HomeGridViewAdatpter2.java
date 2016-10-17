package MyAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.administrator.aishangsanfu.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */

public class HomeGridViewAdatpter2 extends BaseAdapter {
    private  Context context;
    private LayoutInflater layoutInflater;
    private List<String> pathgrid2;

    public HomeGridViewAdatpter2(Context context, List<String> pathgrid2) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.pathgrid2 = pathgrid2;
    }


    @Override
    public int getCount() {
        return pathgrid2.size();
    }

    @Override
    public Object getItem(int position) {
        return pathgrid2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder vh = null;
        if (convertView ==null){
            vh = new ViewHolder();
            convertView = View.inflate(parent.getContext(), R.layout.home_gridview2_item,null);
            vh.iv = (ImageView) convertView.findViewById(R.id.home_noGridView2_imageview);
             convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }try{
            Picasso.with(parent.getContext()).load(pathgrid2.get(position)).into(vh.iv);
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertView;
    }
    class ViewHolder{
        ImageView iv;


    }
}
