package com.example.administrator.mylife.http;


import com.example.administrator.mylife.http.okhttp.callback.ResultCallback;
import com.example.administrator.mylife.http.okhttp.request.OkHttpDownloadRequest;
import com.example.administrator.mylife.http.okhttp.request.OkHttpRequest;
import com.example.administrator.mylife.tool.CommomMethod;
import com.example.administrator.mylife.tool.L;

import java.util.Map;

/**
 * Created by jane on 2016/4/2.
 */
public class HttpRoot {
    public static void postAsyn(String url, Map<String, String> params, ResultCallback callback) {
        if (null == url) {
            return;
        }
        postAsyn(url, params, callback, null);
    }

    /**
     * 等于post请求
     *
     * @param url
     * @param params
     * @param callback
     */
    public static void postAsyn(String url, Map<String, String> params, ResultCallback callback, Object object) {
        if (CommomMethod.isEmpty(url)) {
            return;
        }
        L.i("test", url);
        if (null != params) {
            for (Map.Entry<String, String> tem : params.entrySet()) {
                L.i("test", tem.getKey() + ":" + tem.getValue());
                if (null == tem.getValue()) {
                    return;
                }
            }
        }
        new OkHttpRequest.Builder()
                .url(url)
                .params(params)
                .tag(object)
                .post(callback);
    }

    /**
     * 图片下载
     *
     * @param url      下载的URL
     * @param destPath 存放目标文件地址
     * @param destName 存放目标文件名字
     * @param callback 回调方法
     */
    public static void downLoadFile(String url, String destPath, String destName, ResultCallback callback) {
        new OkHttpDownloadRequest.Builder()
                .url(url)
                .params(null)
                .headers(null)
                .destFileDir(destPath)
                .destFileName(destName)
                .download(callback);
    }


}
