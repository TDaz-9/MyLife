package com.example.administrator.mylife.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.tool.NavBar;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * 图片
 */

public class ImageActivity extends Activity{

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initView();
    }

    private void initView() {
        NavBar navBar = new NavBar(this);
        navBar.setTitle("图片");
        navBar.hideRight();

        getImage();
    }


    private void getImage() {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("https://route.showapi.com/197-1?num=1&page=1&rand=1&showapi_appid=19332&showapi_sign=617de384e428455c95aa23a19dc14c9c")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String json = response.body().string();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ImageActivity.this, json, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
