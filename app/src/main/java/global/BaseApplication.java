package global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import org.xutils.x;


/**
 * Created by Administrator on 2016/10/12.
 */

public class BaseApplication extends Application {
    private   static Context context;
    private static  int  mainThreadId;
    private static Handler handler;
    @Override
    public void onCreate() {
        super.onCreate();
        context  = getApplicationContext();
        mainThreadId = Process.myTid();
        handler = new Handler();
        //声明Xuntils;
        x.Ext.init(this);


    }
    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }
}
