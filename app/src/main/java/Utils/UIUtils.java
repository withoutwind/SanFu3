package Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import global.BaseApplication;

/**
 * Created by Administrator on 2016/10/14.
 */

public class UIUtils {
    public  static Context getContext(){
        return BaseApplication.getContext();
    }

    public static Handler getHandler(  ){
        return  BaseApplication.getHandler();
    }

    public static  int getMainThreadId(){
        return  BaseApplication.getMainThreadId();
    }
    //获取字符串；
    public static  String getString( int id){
        return    getContext().getResources().getString(id);
    }
    //获取字符串数组;
    public  static String[] getStringArray( int id){
        return  getContext().getResources().getStringArray(id);
    }
    //获取图片；
    public  static Drawable getDrawable(int id){
        return getContext().getResources().getDrawable( id);
    }
    public  static int getDimen (int id){
        return getContext().getResources().getDimensionPixelSize(id);
        //返回具体的像素；
    }

    //dp和之间的转换
    public  static  int dip2px(float dip){
        float density  = getContext().getResources().getDisplayMetrics().density;
        return  (int) (dip * density +0.5f);
    }
    public  static float px2dip(int px){
        float density = getContext().getResources().getDisplayMetrics().density;
        return px/ density;
    }
    //加载布局文件；
    public static View inflate (int id){
        return  View.inflate(getContext(),id,null);
    }
    //判断是否运行在主线程；
    public  static boolean isRunOnUIThread(){
        int myTidy =  android.os.Process.myTid();
        if(myTidy == getMainThreadId()){
            return  true;

        }
        return false;
    }
    //运行在主线程；
    public static void runOnUIThread( Runnable r){
        if (isRunOnUIThread()){
            //已经是主线程，直接运行；
            r.run();
        }else{
            //如果是子线程，借助handler让其运行在主线程；
            getHandler().post(r);
        }
    }

}
