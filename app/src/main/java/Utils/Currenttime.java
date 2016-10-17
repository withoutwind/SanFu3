package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/16.
 */

public class Currenttime {
    public static String getCurrenttime(){
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String currentTime = formatter.format(curDate);
        return currentTime;
    }
}
