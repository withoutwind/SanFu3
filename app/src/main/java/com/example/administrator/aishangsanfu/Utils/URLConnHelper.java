package com.example.administrator.aishangsanfu.Utils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/9/13.
 */
public class URLConnHelper {
    public static String loadJSON(String url){
        try{
            URL u=new URL(url);
            URLConnection urlConnection = u.openConnection();
            urlConnection.setConnectTimeout(5000);
            InputStream is = urlConnection.getInputStream();
            byte bs[]=new byte[1024*8];
            int count=0;
            StringBuilder sd=new StringBuilder();
            while((count=is.read(bs))!=-1) {
                String s = new String(bs, 0, count, "utf-8");
                sd.append(s);
            }
            return sd.toString();
        }catch(Exception e){}
        finally {
        }
        return null;
    }
}
