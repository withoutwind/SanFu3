package Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.aishangsanfu.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import MyAdapters.MyAdapter;

import static Utils.Constans.indexBeanList;

/**
 * Created by Administrator on 2016/10/14.
 */

public class HomeFragment extends BaseFragment {
   /* private Toolbar toolbar;
    private DrawerLayout drawer;
    private List<String> list = new ArrayList<String>();
    private RecyclerView recyclerView;
    private MyAdapter ad;
    String path;
    View v;

    //ImageView路径集合；
    List<String> ivpath = new ArrayList<>();
    //imagview集合；
    List<String> ivgrid = new ArrayList<>();
    List<ImageView> imageview = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.homefragment, null);
        initImageView();
       // initDatarecycler();
        initData();

        return v;
    }

    private void initData() {
        if (indexBeanList != null) {
            System.out.println("--"+indexBeanList);
            for (int i = 0; i < 3; i++) {
                if (i == 2 || i == 4) {
                    for (int j = 0; j < indexBeanList.get(i).getList().size(); j++) {
                        ivgrid.add(indexBeanList.get(i).getList().get(j).getImg());
                    }
                } else {
                    for (int j = 0; j < indexBeanList.get(i).getList().size(); j++) {
                        ivpath.add(indexBeanList.get(i).getList().get(j).getImg());
                    }
                }
            }


        }


    }
    //有待优化；

    private void initImageView() {
        int id[] = {R.id.home_one_imageview, R.id.home_two_linearlayout_imageview_11,
                R.id.home_two_linearlayout_imageview_12,
                R.id.home_two_linearlayout_imageview_13,
                R.id.home_two_linearlayout_imageview_14};
        for (int i = 0; i < id.length; i++) {
            ImageView image = (ImageView) v.findViewById(id[i]);
            imageview.add(image);


        }
        for (int i = 0; i < id.length; i++) {
            Picasso.with(getContext()).load(ivpath.get(i)).into(imageview.get(i));
        }

    }
}

*//*
    private void initView() {
        drawer = (DrawerLayout) v.findViewById(R.id.drawer);
        toolbar = (Toolbar) v.findViewById(R.id.first_tb);
        recyclerView = (RecyclerView) v.findViewById(R.id.home_recycler);
        toolbar.setNavigationIcon(R.drawable.abs__ic_menu_moreoverflow_normal_holo_light);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else {
                    drawer.openDrawer(Gravity.LEFT);
                }

            }
        });
        //  LinearLayoutManager linear = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        GridLayoutManager grid = new GridLayoutManager(getContext(),4, LinearLayoutManager.VERTICAL,false);
        //sm = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        grid.setSpanSizeLookup(  new GridLayoutManager.SpanSizeLookup(){

            @Override
            public int getSpanSize(int position) {
                if (position == 0){
                    return 4;
                }
                return 2;
            }
        });



        recyclerView.setLayoutManager(grid);
        ad = new MyAdapter(getContext(),list);
        recyclerView.setAdapter(ad);


        recyclerView.addItemDecoration( new RecyclerView.ItemDecoration(){
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(1,1,1,1);
            }
        });

    }

    private void initDatarecycler() {
        for ( int i = 0 ;i < 100; i++){
            list.add(String.format(Locale.CHINA,"第%03d条数据",i));
        }
    }
}*//*
*/
}