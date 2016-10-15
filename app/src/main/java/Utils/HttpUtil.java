package Utils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/10/12.
 */

public class HttpUtil {

    public  static  String loadJSON(String url){
        try {
            URL u = new URL(url);
            URLConnection conn  = u.openConnection();
            conn.setConnectTimeout(5000);
            InputStream in = conn.getInputStream();
            byte bs[] = new byte[1024*8];
            int count = 0;
            StringBuilder sd = new StringBuilder();
            while ((count=in.read(bs))!= -1){
                String s = new String(bs,0,count,"utf-8");
                sd.append(s);

            }
            return sd.toString();


        }catch (Exception e){

        }finally {

        }
        return null;
    }

}
