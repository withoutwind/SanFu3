package MyAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.aishangsanfu.R;

import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {
    private Context context;
    private List<String> list;
    private  OnChildClickListener listener;
    private RecyclerView recyclerView;


    public void setOnChildClickListener(OnChildClickListener listener) {
        this.listener = listener;
    }

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);

    }
    //连接RecyclerView调用的方法；
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }
    //解除绑定时调用的方法；
    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //复用时调用的方法；
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onClick(View view) {
        if(recyclerView != null && listener !=null){
            int position =   recyclerView.getChildAdapterPosition(view);
            listener.onChildClick(recyclerView,view,position,list.get(position));
        }
    }


    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
    //设置一个回调接口；以便于添加点击事件；  void  onChildClick(RecyclerView parent,View view ,int position, String data);
    //以上的参数自己设定，其中String data 表示的是list的泛型的类型；
    public  interface  OnChildClickListener{
        void  onChildClick(RecyclerView parent, View view, int position, String data);
    }

    //移除操作；
    public void  remove(int position){
        list.remove(position);
        // notifyDataSetChanged();
        notifyItemRemoved(position);
    }
    //添加操作；
    public void add(int position,String data){
        list.add(position,data);
        notifyItemInserted(position);

    }
}
