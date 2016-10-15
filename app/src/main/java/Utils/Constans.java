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
}
