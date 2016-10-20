package Utils;



import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    public static String down(String url){
        OkHttpClient client = new OkHttpClient();

        try {
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
