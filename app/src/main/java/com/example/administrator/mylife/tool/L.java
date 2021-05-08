package com.example.administrator.mylife.tool;

import android.util.Log;

/**
 * Created by zhy on 15/11/6.
 */
public class L
{
//    private static boolean debug = BuildConfig.DEBUG;
    private static boolean debug = true;

    public static void e(String msg)
    {
        if (debug)
        {
            Log.e("OkHttp", msg);
        }
    }
    public static void e(String tag,String msg)
    {
        if (debug)
        {
            Log.e(tag, msg);
        }
    }
    public static void i(String msg)
    {
        if (debug)
        {
            Log.i("OkHttp", msg);
        }
    }
    public static void i(String tag,String msg)
    {
        if (debug)
        {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag,String msg) {
        if (debug) {
            Log.w(tag,msg);
        }
    }

}

