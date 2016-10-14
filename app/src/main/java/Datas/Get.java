package Datas;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import Utils.URLConnHelper;

/**
 * Created by Administrator on 2016/10/11.
 */

public class Get {
    public static JSONObject getDatas(String path){
        String json= URLConnHelper.loadJSON(path);
        JSONObject jj= JSON.parseObject(json);
        String root=jj.getString("msg");
        JSONObject jb= JSON.parseObject(root);
        return jb;
    }
    public static String getIndex(String path){
        JSONObject jb=getDatas(path);
        String index=jb.getString("index");
        return index;
    }
}
