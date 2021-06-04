package com.example.administrator.mylife.ui.activity.studyGlide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.mylife.R;
import com.example.administrator.mylife.tool.NavBar;
import com.example.administrator.mylife.util.SingleTon;
import com.example.administrator.mylife.util.ToastUtils;

/**
 * Created by mengxing on 2017/9/13.
 * Glide框架学习
 */

public class GlideActivity extends AppCompatActivity implements View.OnClickListener{
    private Button loadBtn;
    private Button snackBar;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_glide);
        initView();
    }

    // 加载view
    private void initView() {
        NavBar navBar = new NavBar(this);
        navBar.setTitle("Glide学习");

        // 渲染视图
        loadBtn = (Button) findViewById(R.id.load_image);
        loadBtn.setOnClickListener(this);
        snackBar = (Button) findViewById(R.id.snack_bar);
        snackBar.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.glide_image);
         SingleTon.getInstance().showToast(GlideActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.load_image:
                loadImage();
                break;

            case R.id.snack_bar:
                Snackbar.make(snackBar, "是否删除数据", Snackbar.LENGTH_LONG).setAction("是",new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.getInstance(GlideActivity.this).showToast("数据已删除");
                    }
                }).show();
                break;
            default:
                break;
        }
    }

    private void loadImage() {
        String url = "http://pic.qiantucdn.com/58pic/13/74/51/99d58PIC6vm_1024.jpg!/fw/780/watermark/url/L3dhdGVybWFyay12MS4zLnBuZw==/align/center";
        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.wait)
                .error(R.drawable.error)
                .into(imageView);
    }
}
