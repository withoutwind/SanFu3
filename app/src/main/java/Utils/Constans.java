package Utils;

import java.util.ArrayList;
import java.util.List;

import Bean.HomeBean;
import Bean.SortBean;

/**
 * Created by Administrator on 2016/10/11.
 */

public class Constans {

    public static String homeStr = "http://m.sanfu.com/app/goods/index.htm?id=101&version=3&source=1";

    public static List<HomeBean.MsgBean.IndexBean> indexBeanList ;
    public static  ArrayList<SortBean.MsgBean.CategoryBean> sortdatas;
    public static String sorturl="http://m.sanfu.com/app/goods/sort.htm?source=1&version=1";

    public static String getHomeUrl(String id){
        String url="http://m.sanfu.com/app/goods/index.htm?id="+id+"&version=3&source=1";
        return url;
    }
    public static String getSortUrl(){
        String url="http://m.sanfu.com/app/goods/sort.htm?source=1&version=1";
        return url;
    }
    public static String getDetailsUrl(String goods_sn){
        String url="http://m.sanfu.com/app/display.htm?goods.goods_sn="+goods_sn+"&sid=a9f809a7c00111dd3abc3d49a06da2e4&source=1";
        return url;
    }
    public static String getWebview(int id){
        String url = "http://m.sanfu.com/html/txt/" + id + ".html";
        return url;
    }

}
