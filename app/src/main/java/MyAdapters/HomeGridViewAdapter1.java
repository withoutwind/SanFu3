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

public class HomeGridViewAdapter1 extends BaseAdapter{
     private Context context;
     private LayoutInflater layoutInflater;
     private List<String> pathgrid1;

    public HomeGridViewAdapter1(Context context,  List<String> pathgrid1) {
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
        this.pathgrid1 = pathgrid1;
    }


    @Override
    public int getCount() {
        return pathgrid1.size();
    }

    @Override
    public Object getItem(int position) {
        return pathgrid1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
       ViewHolder  vh= null;
        if (convertView == null){
            vh = new ViewHolder();
            convertView= View.inflate(parent.getContext(), R.layout.home_nogridviewitem,null);
             vh.iv = (ImageView) convertView.findViewById(R.id.home_NoGridView_imageView);
        }else{
            vh= (ViewHolder) convertView.getTag();
        }
        try{

            Picasso.with(parent.getContext()).load(pathgrid1.get(position)).into(vh.iv);
        }catch (Exception e){
            e.printStackTrace();
        }
       /* vh.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });*/
        return convertView;
    }
    class ViewHolder{
        ImageView iv;
    }
}
