package com.example.administrator.aishangsanfu.Utils;

/**
 * Created by Administrator on 2016/10/11.
 */

public class Constans {
    public static String getUrl(String id,String version,String source){
        String url="http://m.sanfu.com/app/goods/index.htm?id="+id+"&version="+version+"&source="+source;
        return url;
    }
}
