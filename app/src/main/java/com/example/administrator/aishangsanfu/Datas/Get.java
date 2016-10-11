package com.example.administrator.aishangsanfu.Datas;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.administrator.aishangsanfu.Utils.URLConnHelper;

import java.util.Collection;

/**
 * Created by Administrator on 2016/10/11.
 */

public class Get {
    public static String getDatas(String path){
        String json= URLConnHelper.loadJSON(path);
        JSONObject jj= JSON.parseObject(json.substring(2));
        String root=jj.getString("msg");
        return root;
    }
}
