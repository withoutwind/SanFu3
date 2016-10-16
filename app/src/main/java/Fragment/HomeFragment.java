package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.administrator.aishangsanfu.ListGoodsActivity;
import com.example.administrator.aishangsanfu.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import MyAdapters.HomeGridViewAdapter1;
import MyAdapters.HomeGridViewAdatpter2;
import MyView.NoScrollGridView;
import Utils.UIUtils;

import static Utils.Constans.indexBeanList;

/**
 * Created by Administrator on 2016/10/14.
 */

public class HomeFragment extends BaseFragment {
    private  View v;
    private int id [];
    private String path;
    private ImageView image;
    private HomeGridViewAdapter1 homead1;
    private HomeGridViewAdatpter2  homead2;
    private List<String> pathlist= new ArrayList<>();
    private List<String> pathgrid1= new ArrayList<>();
    private List<String> pathgrid2= new ArrayList<>();
    private List<String> urlList = new ArrayList<>();



    private NoScrollGridView noGridView1;
    private NoScrollGridView noGridView2;
    private List<ImageView> ivs = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.homefragment, null);
        initurlList();
        initData();

        return v;
    }

    private void initurlList() {

        urlList.add("http://m.sanfu.com/app/display.htm?goods.goods_sn=361226&sid=a9f809a7c00111dd3abc3d49a06da2e4&source=1&key=olrfhmbvsjgbxoq&sign=2FFF494B07C913EB308D27F6E006709F");
        urlList.add("http://m.sanfu.com/app/display.htm?goods.goods_sn=753884&sid=a9f809a7c00111dd3abc3d49a06da2e4&source=1&key=rlpnovthsxxqkla&sign=CC210C96E0664424B3BD29047AFF1239");
        urlList.add("http://m.sanfu.com/app/display.htm?goods.goods_sn=360432&sid=a9f809a7c00111dd3abc3d49a06da2e4&source=1&key=idrouvrnmdkbvpg&sign=360130DB90C2D14726B432DFB171CDC5");
        urlList.add("http://m.sanfu.com/app/display.htm?goods.goods_sn=361091&sid=a9f809a7c00111dd3abc3d49a06da2e4&source=1&key=puhbrpqqfridrdr&sign=638A21334BAB903634F9A8939A289B9F");
        urlList.add("http://m.sanfu.com/app/display.htm?goods.goods_sn=753925&sid=a9f809a7c00111dd3abc3d49a06da2e4&source=1&key=fqhglouaeibpuug&sign=EC568EA6C8AD54803DD86F113D4A6CFD");
        urlList.add("http://m.sanfu.com/app/display.htm?goods.goods_sn=754189&sid=a9f809a7c00111dd3abc3d49a06da2e4&source=1&key=ilcreqssrljnold&sign=3CAE6F4A20EB2C6DA3F795015B9CFC9B");


    }

    private void initData() {
        System.out.println("-----" + indexBeanList);

        if (indexBeanList != null) {
            System.out.println("--666666666" + pathlist);
            System.out.println("--666666666" + pathgrid1);
            System.out.println("--666666666" + pathgrid2);
                pathgrid1.clear();
                pathgrid2.clear();
                for (int i = 0; i < 7; i++) {
                    if (i == 2) {
                        for (int j = 0; j < indexBeanList.get(i).getList().size(); j++) {
                            pathgrid1.add(indexBeanList.get(i).getList().get(j).getImg());
                        }


                    } else if (i == 4) {
                        for (int j = 0; j < indexBeanList.get(i).getList().size(); j++) {
                            if (j == 0) {
                                pathlist.add(indexBeanList.get(i).getList().get(0).getImg());
                            } else {
                                pathgrid2.add(indexBeanList.get(i).getList().get(j).getImg());

                            }
                        }

                    } else {

                        for (int j = 0; j < indexBeanList.get(i).getList().size(); j++) {
                            pathlist.add(indexBeanList.get(i).getList().get(j).getImg());
                        }


                    }
                }
            }
            initImageView();
            initGridView1();
        }


    private void initImageView() {
      int id[]={R.id.home_imagview_one,
              R.id.home_two_linearlayout_imageview_11,
              R.id.home_two_linearlayout_imageview_12,
              R.id.home_two_linearlayout_imageview_13,
              R.id.home_two_linearlayout_imageview_14,
              R.id.home_four_linearlayout_1,
              R.id.home_four_linearlayout_2,
              R.id.home_four_linearlayout_3,
              R.id.home_imagview_two,
              R.id.home_imagview_three,
              R.id.home_imagview_four,
              R.id.home_imagview_five,
              R.id.home_six_linearlayout_1_imageview1,
              R.id.home_six_linearlayout_1_imageview2,
              R.id.home_six_linearlayout_1_imageview3,
              R.id.home_six_linearlayout_1_imageview4};
        for(int i = 0;i < id.length;i++){
            ImageView iamge = (ImageView) v.findViewById(id[i]);
            ivs.add(iamge);
        }
        noGridView1 = (NoScrollGridView) v.findViewById(R.id.home_noGridView1);
        noGridView2 = (NoScrollGridView) v.findViewById(R.id.home_noGridView2);
    }

    private void initGridView1() {
        System.out.println("--11"+pathlist);
        System.out.println("--22"+pathgrid1);
        System.out.println("--33"+pathgrid2);
        for (int h= 0; h < pathlist.size();h++){
            Picasso.with(UIUtils.getContext()).load(pathlist.get(h)).into(ivs.get(h));
        }



        homead1 = new HomeGridViewAdapter1(getContext(), pathgrid1);
        noGridView1.setAdapter(homead1);

        noGridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        homead2 = new HomeGridViewAdatpter2(getContext(),pathgrid2);
        noGridView2.setAdapter(homead2);
        noGridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ListGoodsActivity.class);
                intent.putExtra("item",position);
                intent.putExtra("url",urlList.get(position));
                startActivity(intent);

            }
        });

          System.out.println("--222"+pathgrid2);
      }


}




