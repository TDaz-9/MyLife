package com.example.administrator.mylife.tool;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class CommomMethod {
    public static boolean isEmpty(String str) {
        if (str != null && str.trim().length() > 0)
            return false;
        return true;
    }
}
