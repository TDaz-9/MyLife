package com.example.administrator.mylife.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 瀛熸槦 on 2017/9/14.
 * danli
 */

public class SingleTon {
    private static SingleTon singleTon;

    private SingleTon() {

    }

    public static SingleTon getInstance() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

    public void showToast(Context context) {
        Toast.makeText(context, "aaa", Toast.LENGTH_SHORT).show();
    }
}
