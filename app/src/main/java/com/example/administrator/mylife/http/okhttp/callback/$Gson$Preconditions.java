package com.example.administrator.mylife.http.okhttp.callback;

/**
 * Created by Administrator on 2016/4/11.
 */
public final class $Gson$Preconditions {
    public static <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    public static void checkArgument(boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException();
        }
    }
}
